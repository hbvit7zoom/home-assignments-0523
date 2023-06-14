package ru.sberbank.jd.lesson10.webinar05;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StandartDeserialisation {
    public static void main(String[] args) {

        try (InputStream is = Files.newInputStream(Paths.get("car.bin"));
             ObjectInputStream ois = new ObjectInputStream(is);
        ){
            Object object = ois.readObject();
            Car1 car = (Car1) object;
            System.out.println(car);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
