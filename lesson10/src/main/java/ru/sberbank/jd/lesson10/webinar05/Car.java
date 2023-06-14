package ru.sberbank.jd.lesson10.webinar05;

import java.io.Serializable;

public class Car implements Serializable {

    private static final long serialVersionUID = 587097489569920216L;

    private String model;
    private int year;


    public Car(String model, int year) {
        this.model = model;
        this.year = year;

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

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", year=" + year +
                '}';
    }
}
