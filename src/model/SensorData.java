package model;

import java.time.LocalDateTime;

public class SensorData {
    private int id; // будет из БД
    private double speed;
    private double acceleration;
    private LocalDateTime timestamp;

    public SensorData(int id, double speed, double acceleration, LocalDateTime timestamp) {
        this.id = id;
        this.speed = speed;
        this.acceleration = acceleration;
        this.timestamp = timestamp;
    }

    public SensorData(double speed, double acceleration, LocalDateTime timestamp) {
        this(0, speed, acceleration, timestamp);
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public double getSpeed() { return speed; }
    public void setSpeed(double speed) { this.speed = speed; }

    public double getAcceleration() { return acceleration; }
    public void setAcceleration(double acceleration) { this.acceleration = acceleration; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    @Override
    public String toString() {
        return "SensorData{speed=" + speed + ", acceleration=" + acceleration + ", timestamp=" + timestamp + "}";
    }
}
