package ru.sberbank.jd.lesson02;

/**
 * Интерфейс для определения наибольшего общего делителя двух целых чисел.
 */
public interface Nod {

    /**
     * Вычисляет наибольший общий делитель двух целых чисел.
     *
     * @param first  первое число
     * @param second второе число
     * @return наибольший общий делитель
     */
    int calculate(int first, int second);
}
