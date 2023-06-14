package ru.sberbank.jd.lesson10.webinar05;

import java.io.Serializable;

public class Car1 implements Serializable {

    private static final long serialVersionUID = 587097489569920216L;

    private String model;
    private int year;
    private String color;

    private Vehicle vehicle;

    public Car1(String model, int year, String color, Vehicle vehicle) {
        this.model = model;
        this.year = year;
        this.color = color;
        this.vehicle = vehicle;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", vehicle=" + vehicle +
                '}';
    }
}
