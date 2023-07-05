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
import java.util.Arrays;
import java.util.Map;

@WebServlet(name = "CalculatorServlet", value = {"/calc", "/result"})
public class CalculatorServlet extends HttpServlet {
    private CalculatorService calculatorService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.calculatorService = new CalculatorServiceImpl(new InMemoryCalcRepositoryImpl());
    }

    // param1
    // param2
    // operation
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> params =  req.getParameterMap();
//        validateParamsForSum(params);
        if(params.size() == 2) {
            double param1 = Double.parseDouble(req.getParameter("param1"));
            double param2 = Double.parseDouble(req.getParameter("param2"));
            CalcResult result = calculatorService.sum(param1, param2);

            resp.getOutputStream().write(result.getId().getBytes());
            resp.getOutputStream().flush();
        } else {

            String id = req.getParameter("id");
            CalcResult result = calculatorService.findResultById(id);

            resp.getOutputStream().write(result.toString().getBytes());
            resp.getOutputStream().flush();
        }
    }

    private void validateParamsForSum(Map<String, String[]> params) {
        if(params.size() != 2) {
            throw new RuntimeException("Amount of params must be 2");
        }
    }
}
