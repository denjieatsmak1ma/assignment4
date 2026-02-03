package model;

public class VehicleCollision extends AccidentEvent {
    private int vehiclesInvolved;

    public VehicleCollision(int id, String location, double latitude, double longitude, int severity,
                            SensorData sensorData, int vehiclesInvolved) {
        super(id, location, latitude, longitude, severity, sensorData);
        setVehiclesInvolved(vehiclesInvolved);
    }

    public int getVehiclesInvolved() { return vehiclesInvolved; }
    public void setVehiclesInvolved(int vehiclesInvolved) {
        if (vehiclesInvolved < 1) throw new IllegalArgumentException("Vehicles involved must be at least 1");
        this.vehiclesInvolved = vehiclesInvolved;
    }

    @Override
    public String getAccidentType() { return "VEHICLE_COLLISION"; }

    @Override
    public void processAccident() {
        System.out.println("Processing vehicle collision. Vehicles involved: " + vehiclesInvolved);
    }

    @Override
    public String getAccidentSummary() {
        return "VehicleCollision{id=" + getId() + ", location='" + getLocation() + "', severity=" + getSeverity() +
                ", vehicles=" + vehiclesInvolved + "}";
    }
}
