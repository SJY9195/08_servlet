package com.ohgiraffers.question.post.controller;

import com.ohgiraffers.question.model.dto.PostDTO;
import com.ohgiraffers.question.model.service.PostService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;


@WebServlet("/selectAll")
public class SelectAllServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PostService postService = new PostService();
        List<PostDTO> postList = postService.selectAllPost();

        for (PostDTO post:postList){   //for each문 List를 뿌려주는 문
            System.out.println(post);
        }

        req.setAttribute("postList", postList);
        req.getRequestDispatcher("/WEB-INF/views/main/main.jsp").forward(req, resp);  //setAttribute 한걸 main으로 forward!

    }
}
