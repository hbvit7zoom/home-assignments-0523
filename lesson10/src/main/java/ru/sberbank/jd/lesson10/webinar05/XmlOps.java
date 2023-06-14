package ru.sberbank.jd.lesson10.webinar05;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.util.List;

public class XmlOps {

    public static void main(String[] args) throws JsonProcessingException {
//        String person = new StringBuilder()
//                .append("<person>")
//                .append("<lastName>")
//                .append("Пушкин")
//                .append("</lastName>")
//                .append("<NAME>")
//                .append("Александр")
//                .append("</NAME>")
//                .append("</person>")
//                .toString();
//
//        XmlMapper xmlMapper = new XmlMapper();
//        Person person1 = xmlMapper.readValue(person, Person.class);
        Person person1 = new Person("Александр", "Пушкин",
                List.of(new Book("Руслан и Людмила"), new Book("Евгений Онегин")));


        System.out.println(person1);

        XmlMapper xmlMapper = new XmlMapper();
        String s = xmlMapper.writeValueAsString(person1);
        System.out.println(s);

    }
}
