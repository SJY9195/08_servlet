package com.ohgiraffers.question.post.controller;

import com.ohgiraffers.question.model.dto.PostDTO;
import com.ohgiraffers.question.model.service.PostService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/edit")
public class UpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        System.out.println("id = " + id);
        PostService postService = new PostService();
        PostDTO postDTO = postService.selectOneId(id);

        System.out.println("postDTO = " + postDTO);

        String path="";
        path = "/WEB-INF/views/post/update.jsp";
        if(postDTO != null){
            req.setAttribute("postDTO", postDTO);
        }
        req.getRequestDispatcher(path).forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       int id = Integer.parseInt(req.getParameter("id"));
       String title = req.getParameter("title");
       String content = req.getParameter("content");

       PostService postService = new PostService();

       PostDTO board = new PostDTO();

       board.setId(id);
       board.setTitle(title);
       board.setContent(content);

       int result = postService.updatePost(board);

        System.out.println("수정 성공여부 : " + result);

        resp.sendRedirect("selectAll");

    }
}
