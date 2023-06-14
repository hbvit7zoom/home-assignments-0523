package ru.sberbank.jd.lesson12.model;


import java.util.Date;
import java.util.UUID;

/**
 * Класс, отражающий структуру хранимых в таблице полей.
 */
public class Student {

    /*
     * Первичный ключ.
     *
     * Рекомендуется генерировать его только внутри StudentsRepositoryCRUD.create(),
     * иными словами до момента пока объект не будет сохранен в БД, он не должен
     * иметь значение id.
     */
    private UUID id;

    private String firstName;

    private String lastName;

    private Date birthDate;

    private boolean isGraduated;

}
