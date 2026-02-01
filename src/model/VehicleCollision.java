package model;

public class VehicleCollision extends AccidentEvent{
    private int vehiclesInvolved;

    public VehicleCollision(int id,String location,double latitude, double longitude, int severity, SensorData sensorData, int vehiclesInvolved){
        super(id,location,latitude,longitude,severity,sensorData);
        this.vehiclesInvolved=vehiclesInvolved;
    }

    public int getVehiclesInvolved(){
        return vehiclesInvolved;
    }

    public void setVehiclesInvolved(int vehiclesInvolved){
        if(vehiclesInvolved<1){
            throw new IllegalArgumentException("Vehicless involved must be at least 1");
        }
        this.vehiclesInvolved=vehiclesInvolved;
    }

    @Override
    public String getAccidentType(){
        return "VEHICLE_COLLISION";
    }

    @Override
    public void processAccident(){
        System.out.println("Processing vehicle collision with " + vehiclesInvolved + " vehicles involved");
    }
}
