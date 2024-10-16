package com.ohgiraffers.section02.uses;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.IOException;

@WebServlet("/member/regist")
public class RegistMemberServlet extends HttpServlet {
 //가입하기, 로그인 로직이 섞여있는것이다.
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        String name = req.getParameter("name");

        System.out.println("userId = " + userId);
        System.out.println("password = " + password);
        System.out.println("name = " + name);                  //실제로 이렇게 콘솔로 찍으면 불법이므로 주의해야한다!

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println("비밀번호가 pass01인지 확인 : " +
                passwordEncoder.matches("pass01",password));  //matches의 인자로 입력받은걸 앞에, DB에 있는걸 뒤에 넣어야 한다!
        // 암호화 된 내용을 2번째 인자로 전달해야 한다..
    }
}
