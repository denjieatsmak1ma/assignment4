package model;

public class PedestrianAccident extends AccidentEvent {
    private boolean pedestrianInjured;

    public PedestrianAccident(int id, String location, double latitude, double longitude, int severity,
                              SensorData sensorData, boolean pedestrianInjured) {
        super(id, location, latitude, longitude, severity, sensorData);
        this.pedestrianInjured = pedestrianInjured;
    }

    public boolean isPedestrianInjured() { return pedestrianInjured; }
    public void setPedestrianInjured(boolean pedestrianInjured) { this.pedestrianInjured = pedestrianInjured; }

    @Override
    public String getAccidentType() { return "PEDESTRIAN_ACCIDENT"; }

    @Override
    public void processAccident() {
        System.out.println("Processing pedestrian accident. Injured: " + (pedestrianInjured ? "YES" : "NO"));
    }

    @Override
    public String getAccidentSummary() {
        return "PedestrianAccident{id=" + getId() + ", location='" + getLocation() + "', severity=" + getSeverity() +
                ", injured=" + pedestrianInjured + "}";
    }
}
