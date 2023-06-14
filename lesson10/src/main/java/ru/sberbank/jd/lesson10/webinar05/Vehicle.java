package ru.sberbank.jd.lesson10.webinar05;

import java.io.Serializable;

public class Vehicle implements Serializable {

    private int maxSpeed;

    public Vehicle(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "maxSpeed=" + maxSpeed +
                '}';
    }
}
