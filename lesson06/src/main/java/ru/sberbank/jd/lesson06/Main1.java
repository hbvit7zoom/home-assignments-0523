package ru.sberbank.jd.lesson06;

import java.util.ArrayList;

public class Main1 {

    public static void main(String[] args) {
        Adder<Integer> intAdder = new Adder<>();
        Integer sum = intAdder.sum(3, 6);
        System.out.println(sum);

        Adder<Long> intAdder1 = new Adder<>();
        Long sum1 = intAdder1.sum(3L, 6L);
        System.out.println(sum1);

//        Adder<String> intAdder2 = new Adder<>();
//        String sum2 = intAdder2.sum("123", "456");
//        System.out.println(sum2);
    }
}
