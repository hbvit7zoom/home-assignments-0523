package ru.sberbank.jd.lesson06;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("5");
        list.add("5");
        list.add("5");

        System.out.println(list);

        for (String obj : list) {
            System.out.println("String");
        }
    }
}
