package ru.sberbank.jd.lesson10.webinar05;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StandartSerialization {

    public static void main(String[] args) {
        Car1 car = new Car1("Audi", 2020, "Red", new Vehicle(300));

        try (OutputStream os = Files.newOutputStream(Paths.get("car.bin"));
             ObjectOutputStream oos = new ObjectOutputStream(os);
        ){
            oos.writeObject(car);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
