package model;

public abstract class AccidentEvent implements Detectable {
    private int id;
    private String location;
    private double latitude;
    private double longitude;
    private int severity;
    private SensorData sensorData;

    public AccidentEvent(int id, String location, double latitude, double longitude, int severity, SensorData sensorData) {
        this.id = id;
        setLocation(location);
        setLatitude(latitude);
        setLongitude(longitude);
        setSeverity(severity);
        this.sensorData = sensorData;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getLocation() { return location; }
    public void setLocation(String location) {
        if (location == null || location.trim().isEmpty()) {
            throw new IllegalArgumentException("Location cannot be empty");
        }
        this.location = location;
    }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    public int getSeverity() { return severity; }
    public void setSeverity(int severity) {
        if (severity < 1 || severity > 10) {
            throw new IllegalArgumentException("Severity must be between 1 and 10");
        }
        this.severity = severity;
    }

    public SensorData getSensorData() { return sensorData; }
    public void setSensorData(SensorData sensorData) { this.sensorData = sensorData; }

    public abstract void processAccident();
    public abstract String getAccidentSummary();

    public void printLocation() {
        System.out.println("Location: " + location + " (" + latitude + ", " + longitude + ")");
    }
}
