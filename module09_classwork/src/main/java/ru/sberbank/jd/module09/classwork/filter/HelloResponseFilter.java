package ru.sberbank.jd.module09.classwork.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(filterName = "HelloResponseFilter", servletNames = {"MyFirstServlet"})
public class HelloResponseFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpRs = (HttpServletResponse) response;
        httpRs.addHeader("hello-header", "Nikita");
        chain.doFilter(request, response);
    }
}
