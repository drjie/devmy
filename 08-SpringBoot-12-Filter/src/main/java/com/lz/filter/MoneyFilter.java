package com.lz.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.logging.LogRecord;

//@WebFilter("/*")
//@Component
//@Order(1)
public class MoneyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.printf("过滤条件前:只要有钱的");

        filterChain.doFilter(servletRequest,servletResponse);

        System.out.printf("过滤条件后:很有钱");
    }
}
