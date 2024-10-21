package com.ohgiraffers.question.post.controller;

import com.ohgiraffers.question.model.dto.PostDTO;
import com.ohgiraffers.question.model.service.PostService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/newBoard")
public class InsertServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/post/create.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        PostService postService = new PostService();

        PostDTO board = new PostDTO();
        board.setTitle(title);
        board.setContent(content);

        int result = postService.insertPost(board);

        System.out.println("게시글 성공여부 : " + result);

        resp.sendRedirect("selectAll");  // redirect는 / 빼야한다!

    }
}
