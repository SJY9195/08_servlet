package com.ohgiraffers.question;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

//WebServlet은 Tomcat 서버의 객체이다!
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private String USER_ID = "";
    private String PASSWORD = "";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        System.out.println("password = " + password);

        HttpSession session = req.getSession();
        USER_ID = (String) session.getAttribute("userId");
        PASSWORD = (String) session.getAttribute("password");

        if (USER_ID == null && PASSWORD == null) {
            req.setAttribute("errorMessage", "ID나 Password가 다릅니다!");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println("test : : " + encoder.matches(password, PASSWORD));
        if (USER_ID.equals(userId) && PASSWORD.equals(password)) {
            // 로그인 성공 시 세션에 사용자 정보 저장
            session = req.getSession();
            session.setAttribute("user", userId);
            resp.sendRedirect("/main");
        } else {
            // 로그인 실패 시 에러 메시지와 함께 로그인 페이지로 forward
            req.setAttribute("errorMessage", "id나 비밀번호가 다릅니다.");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }

    }

   /* 내가 썼던 답 @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        Enumeration<String> sessionUser = session.getAttributeNames();
        while(sessionUser.hasMoreElements()){
            System.out.println(sessionUser.nextElement());
        }

        String userId = (String)session.getAttribute("userId");
        String password = (String)session.getAttribute("password");

        /* String userId = (String) req.getAttribute("userId");
        System.out.println(userId);
        String password = (String) req.getAttribute("password");
        System.out.println(password);   //오답 */



        /*BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (passwordEncoder.matches("0000", password)) {
            RequestDispatcher rd = req.getRequestDispatcher("main");
            rd.forward(req, resp);
        } else {
            req.setAttribute("errorMessage", "ID 또는 Password가 다릅니다!");
        } */
}
