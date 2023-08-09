package ru.sberbank.jd.inventory.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryHelloController {

    @GetMapping("inventory/hello")
    public String getInventoryHello() {
        return "Hello, I am inventory";
    }
}
