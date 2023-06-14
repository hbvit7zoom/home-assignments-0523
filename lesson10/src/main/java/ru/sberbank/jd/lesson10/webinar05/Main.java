package ru.sberbank.jd.lesson10.webinar05;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Bmw", 1990));
        cars.add(new Car("Bmw", 1991));
        cars.add(new Car("Mercedes", 1995));
        cars.add(new Car("Chewrolet Niva", 2015));
        cars.add(new Car("Niva", 1970));

//        List<Car> oldCars = new ArrayList<>();
//        for (Car car : cars) {
//            if (car.getYear() < 2000) {
//                oldCars.add(car);
//            }
//        }

//        List<Car> oldCars = cars.stream()
////                .filter(c -> c.getYear() < 2000)
//
////                .filter(new Predicate<Car>() {
////                    @Override
////                    public boolean test(Car car) {
////                        return car.getYear() < 2000;
////                    }
////                })
//
//                .filter((t) -> {
//                    System.out.println(t.getModel());
//                    return t.getYear() < 2000;
//                })
//
//                .collect(Collectors.toList());

//        Stream<Car> carStream = cars.stream()
//                .filter((t) -> {
//                    System.out.println(t.getModel());
//                    return t.getYear() < 2000;
//                });
//
//        carStream.collect(Collectors.toList());


        List<String> oldCarModels = cars.stream()
                .filter((t) -> t.getYear() < 2000)
//                .map(new Function<Car, String>() {
//                    @Override
//                    public String apply(Car car) {
//                        return car.getModel();
//                    }
//                })
//                .map(car -> car.getModel())
                .map(Car::getModel)
                .distinct()
                .collect(Collectors.toList());


        System.out.println(cars);
        System.out.println(oldCarModels);

        System.out.println(cars.stream()
                .filter((t) -> t.getYear() < 2000)
                .map(Car::getModel)
                .distinct()
                .count());

        System.out.println(cars.stream()
//                .filter((t) -> t.getYear() < 2000)
//                .peek(System.out::println)
                        .dropWhile(car -> car.getYear() < 1995)
                .flatMap((Function<Car, Stream<?>>) car -> Stream.of(car.getModel()))
                .collect(Collectors.toList()));

        List<Car> cars1 = new ArrayList<>();
        cars1.add(new Car("Bmw", 1990));
        cars1.add(new Car("Bmw", 1991));
        cars1.add(new Car("Mercedes", 1995));
        List<Car> cars2 = new ArrayList<>();
        cars2.add(new Car("Chewrolet Niva", 2015));
        cars2.add(new Car("Niva", 1970));

        List<Car> collect = List.of(cars1, cars2).stream()
                .flatMap(l -> l.stream())
                .collect(Collectors.toList());

        System.out.println(collect);
    }
}
