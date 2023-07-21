package ru.sberbank.jd.module11.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
@Slf4j
public class HelloWorldController {

    @GetMapping(path = "/{name}")
    public String getHello(@PathVariable String name) {
        log.info("GET getHello with name = {}", name);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{")
                .append("\"hello\":")
                .append("\"" + name + "\"")
                .append("}");
        return stringBuilder.toString();
//        return """
//                {
//                    "hello": ""
//                }""";
    }
}
