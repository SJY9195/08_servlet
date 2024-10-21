package com.ohgiraffers.question.post.controller;

import com.ohgiraffers.question.model.dto.PostDTO;
import com.ohgiraffers.question.model.service.PostService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/detail")
public class SelectOneServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        System.out.println("id = " + id);
        PostService postService = new PostService();
        PostDTO postDTO = postService.selectOneId(id);

        System.out.println("postDTO = " + postDTO);

        String path = "";
        path = "/WEB-INF/views/post/detail.jsp";

        if (postDTO != null){
            req.setAttribute("postDTO", postDTO);
        }

        req.getRequestDispatcher(path).forward(req, resp);

    }
}
