package dto;

import model.AccidentEvent;
import model.SensorData;

public class AccidentDTO {
    private String type;
    private String location;
    private double latitude;
    private double longitude;
    private int severity;

    private Integer vehiclesInvolved;
    private Boolean pedestrianInjured;

    public AccidentDTO(String type, String location, double latitude, double longitude,
                       int severity, Integer vehiclesInvolved,Boolean pedestrianInjured) {
        this.type = type;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.severity = severity;
        this.vehiclesInvolved = vehiclesInvolved;
        this.pedestrianInjured = pedestrianInjured;
    }

    public static AccidentDTO fromModel(AccidentEvent accident) {
        return null;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public double getLatitude() {
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

    public int getSeverity() {
        return severity;
    }
    public void setSeverity(int severity) {
        this.severity = severity;
    }

    public Integer getVehiclesInvolved() {
        return vehiclesInvolved;
    }
    public void setVehiclesInvolved(Integer vehiclesInvolved) {
        this.vehiclesInvolved = vehiclesInvolved;
    }

    public Boolean getPedestrianInjured() {
        return pedestrianInjured;
    }
    public void setPedestrianInjured(Boolean pedestrianInjured) {
        this.pedestrianInjured = pedestrianInjured;
    }

    public AccidentEvent toModel() {
        return null;
    }

    public void setSensorData(SensorData sensorData) {
    }
}
