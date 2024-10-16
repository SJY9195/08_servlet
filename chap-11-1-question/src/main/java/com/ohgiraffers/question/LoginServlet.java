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



    @Override
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



        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (passwordEncoder.matches("0000", password)) {
            RequestDispatcher rd = req.getRequestDispatcher("main");
            rd.forward(req, resp);
        } else {
            req.setAttribute("errorMessage", "ID 또는 Password가 다릅니다!");
        }

    }
}