package ru.sberbank.jd.module09.classwork.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter(filterName = "HelloRequestFilter", servletNames = {"MyFirstServlet"})
public class HelloRequestFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRq = (HttpServletRequest) request;
        var headerNames = httpRq.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            System.out.println(headerNames.nextElement());
        }
        chain.doFilter(request, response);
    }
}
