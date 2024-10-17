package com.ohgiraffers.question;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String userId = (session != null) ? (String) session.getAttribute("user") : null;

        if (userId == null) {
            // 로그인이 안 된 경우 로그인 페이지로 redirect
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        } else {
            // 로그인된 사용자에게 메인 페이지 제공
            req.setAttribute("userId", userId);
            req.getRequestDispatcher("/main.jsp").forward(req, resp);
        }

    }

    /* 내가 썼던 오답 jsp에 java코드를 쓸줄 몰랐다;;@Override
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


    } */
}
