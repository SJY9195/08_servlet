package com.ohgiraffers.question.post.controller;

import com.ohgiraffers.question.model.service.PostService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id")); // 입력받은건 String 이므로 parseInt 해야 한다!
        System.out.println("id = " + id);
        PostService postService = new PostService(); //Service 객체 생성!

        int result = postService.deletePost(id);

        System.out.println("삭제 성공 여부 : " + result);

        resp.sendRedirect("selectAll");
    }
}
