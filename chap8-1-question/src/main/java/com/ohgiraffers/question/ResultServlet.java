package com.ohgiraffers.question;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/result")
public class ResultServlet extends HttpServlet {

    // GET 요청 처리: 게시글 결과 출력
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // request에서 제목과 내용 가져오기
        String title = (String) request.getAttribute("title");
        String content = (String) request.getAttribute("content");

        // HTML 응답을 위한 StringBuilder 객체 생성
        StringBuilder responseText = new StringBuilder();

        // 응답의 콘텐츠 타입 설정
        response.setContentType("text/html;charset=UTF-8");

        // HTML 응답 작성
        responseText.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head><title>게시글 결과</title></head>\n")
                .append("<body>\n")
                .append("<h1>게시글이 작성되었습니다.</h1>\n")
                .append("<h2>제목: ")
                .append(title)
                .append("</h2>\n")
                .append("<p>내용: ")
                .append(content)
                .append("</p>\n")
                .append("</body>\n")
                .append("</html>");

        PrintWriter out = response.getWriter();
        out.print(responseText);
        out.flush();
        out.close();
    }
}