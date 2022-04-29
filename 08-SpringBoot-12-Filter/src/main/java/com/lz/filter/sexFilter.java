package com.lz.filter;

import javax.servlet.*;
import java.io.IOException;

public class sexFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("过滤条件前：只要性别为女的");
        chain.doFilter(request, response);
        System.out.println("过滤条件后：很有女人味");
    }
}
