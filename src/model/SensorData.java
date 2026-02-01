package model;

import java.time.LocalDateTime;

public class SensorData {
    private double speed;
    private double acceleration;
    private LocalDateTime timestamp;

    public SensorData(double speed, double acceleration, LocalDateTime timestamp){
        this.speed=speed;
        this.acceleration=acceleration;
        this.timestamp=timestamp;
    }

    public double getAcceleration() {
        return acceleration;
    }
    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString(){
        return "SensorData{" + "speed="+ speed + ", acceleration=" + acceleration+ ", timestamp=" + timestamp+ "}";
    }
}
