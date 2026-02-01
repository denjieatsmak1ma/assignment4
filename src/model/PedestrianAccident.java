package model;

public class PedestrianAccident extends AccidentEvent{
    private boolean pedestrianInjured;

    public PedestrianAccident(int id,String location, double latitude, double longitude, int severity, SensorData sensorData, boolean pedestrianInjured){
        super(id, location, latitude, longitude, severity, sensorData);
        this.pedestrianInjured=pedestrianInjured;
    }

    public boolean isPedestrianInjured() {
        return pedestrianInjured;
    }

    public void setPedestrianInjured(boolean pedestrianInjured){
        this.pedestrianInjured=pedestrianInjured;
    }

    @Override
    public String getAccidentType(){
        return "PEDSTRIAN_ACCIDENT";
    }

    @Override
    public void processAccident(){
        if(pedestrianInjured){
            System.out.println("Processing pedestrian accident: pedesttrian injured");
        } else {
            System.out.println("Processing pedestrian accident: no injures");
        }
    }
}
