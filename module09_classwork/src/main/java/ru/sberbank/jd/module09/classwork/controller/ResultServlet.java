package ru.sberbank.jd.module09.classwork.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.sberbank.jd.module09.classwork.model.CalcResult;
import ru.sberbank.jd.module09.classwork.repository.InMemoryCalcRepositoryImpl;
import ru.sberbank.jd.module09.classwork.service.CalculatorService;
import ru.sberbank.jd.module09.classwork.service.CalculatorServiceImpl;

import java.io.IOException;

//@WebServlet(name = "ResultServlet", value = "/result")
//public class ResultServlet extends HttpServlet {
//
//    private CalculatorService calculatorService;
//
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        super.init(config);
//        this.calculatorService = new CalculatorServiceImpl(new InMemoryCalcRepositoryImpl());
//    }
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String id = req.getParameter("id");
//        CalcResult result = calculatorService.findResultById(id);
//
//        resp.getOutputStream().write(result.toString().getBytes());
//        resp.getOutputStream().flush();
//
//    }
//}
