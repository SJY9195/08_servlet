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

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        System.out.println("userId = " + userId);
        System.out.println("password = " + password);
        System.out.println("email = " + email);

        HttpSession session = req.getSession();

        session.setAttribute("userId", userId);
        session.setAttribute("password", password);

        resp.sendRedirect("login");

        /*req.setAttribute("userId", userId);  //setAttribute 는 forward로 밖에 못받는다! 그래서 session에 담아두는게 좋다!
        req.setAttribute("password", password);

        RequestDispatcher rd = req.getRequestDispatcher("login");

        rd.forward(req, resp);*/
    }
}
