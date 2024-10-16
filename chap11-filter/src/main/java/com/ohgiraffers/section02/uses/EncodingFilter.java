package com.ohgiraffers.section02.uses;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//어노테이션이 필요없다(ex : Webservlet)
public class EncodingFilter implements Filter {

    private String encodingType;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encodingType = filterConfig.getInitParameter("encoding-type");  //web.xml에서 불러오는것이다!

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletResponse hresponse = (HttpServletResponse) servletResponse;

        hresponse.setContentType(encodingType);

        filterChain.doFilter(servletRequest, servletResponse);

    }
}
