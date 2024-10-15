package com.ohgiraffers.section01.othersite;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/othersite")
public class OtherSiteRedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get 요청 후 naver 로 redirect");
        resp.sendRedirect("https://www.naver.com"); //domain을 살 수도 있다.
    }
}