package model;

public abstract class AccidentEvent implements Detectable{
    protected int id;
    protected String location;
    protected double latitude;
    protected double longitude;
    protected int severity;
    protected SensorData sensorData;

    public AccidentEvent(int id,String location,double latitude, double longitude, int severity, SensorData sensorData){
        this.id=id;
        this.location=location;
        this.latitude=latitude;
        this.longitude=longitude;
        this.severity=severity;
        this.sensorData=sensorData;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }

    public String getLocation(){
        return location;
    }
    public void setLocation(String location){
        if(location==null || location.isEmpty()){
            throw new IllegalArgumentException("Location cannot be empty");
        }
        this.location=location;
    }

    public double getLatitude(){
        return latitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getSeverity(){
        return severity;
    }

    public void setSeverity(int severity) {
        if(severity<1 || severity>10){
            throw new IllegalArgumentException("Severity must be between 1 and 10");
        }
        this.severity = severity;
    }

    public SensorData getSensorData(){
        return sensorData;
    }

    public void setSensorData(SensorData sensorData) {
        this.sensorData = sensorData;
    }

    public abstract void processAccident();
}

