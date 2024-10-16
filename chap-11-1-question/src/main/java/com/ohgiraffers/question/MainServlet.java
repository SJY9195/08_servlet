package com.ohgiraffers.question;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/main")
public class MainServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userId = (String) req.getAttribute("userId");

        StringBuilder responseText = new StringBuilder();

        resp.setContentType("text/html;charset=UTF-8");

        responseText.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head><title>로그인 결과</title></head>\n")
                .append("<body>\n")
                .append("<h1>" + userId + "님! 환영합니다!</h1>\n")
                .append("<a href=login.jsp>로그아웃</a>\n")
                .append("</body>\n")
                .append("</html>");

        PrintWriter out = resp.getWriter();
        out.print(responseText);
        out.flush();
        out.close();


    }
}
