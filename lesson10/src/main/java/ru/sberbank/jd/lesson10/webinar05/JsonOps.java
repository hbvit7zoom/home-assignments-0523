package ru.sberbank.jd.lesson10.webinar05;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.util.List;

public class JsonOps {

    public static void main(String[] args) throws JsonProcessingException {
        String person = """
                {
                  "firstName": "Александр",
                  "lastName": "Пушкин",
                  "books": [
                    {
                      "title": "Руслан и Людмила"
                    },
                    {
                      "title": "Евгений Онегин"
                    }
                  ]
                }
                """;
//
        ObjectMapper objectMapper = new ObjectMapper();
        Person person2 = objectMapper.readValue(person, Person.class);
        System.out.println("person2: " + person2);
        Person person1 = new Person("Александр", "Пушкин",
                List.of(new Book("Руслан и Людмила"), new Book("Евгений Онегин")));


        System.out.println(person1);

        String s = objectMapper.writeValueAsString(person1);
        System.out.println(s);

    }
}
