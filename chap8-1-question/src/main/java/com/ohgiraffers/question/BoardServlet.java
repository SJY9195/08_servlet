package com.ohgiraffers.question;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/*@WebServlet("/board")
public class BoardServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        boolean isTitleValid = title.length() >= 5;
        boolean isContentValid = content.length() >= 10;

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        if (isTitleValid && isContentValid) {
            out.println("<h1>" + title + "</h1>");
            out.println("<p>" + content + "</p>");
        } else {
            out.println("<h1>제목은 5자 이상,내용은 10자 이상이여야 합니다!</h1>");
        }
        out.close();
    }
} 내오답*/
