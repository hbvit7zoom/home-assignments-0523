package ru.sberbank.jd.module09.classwork.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.sberbank.jd.module09.classwork.repository.InMemoryCalcRepositoryImpl;
import ru.sberbank.jd.module09.classwork.service.CalculatorServiceImpl;

import java.io.IOException;

@WebServlet(name = "MyFirstServlet", value = "/hello")
public class MyFirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String hello = "Hello";
        resp.getOutputStream().write(hello.getBytes());
        resp.getOutputStream().flush();
    }
}
