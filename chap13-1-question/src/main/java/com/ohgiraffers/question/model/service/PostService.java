package com.ohgiraffers.question.model.service;

import com.ohgiraffers.question.model.dao.PostDAO;
import com.ohgiraffers.question.model.dto.PostDTO;
import jakarta.servlet.http.Cookie;

import java.sql.Connection;
import java.util.List;

import static com.ohgiraffers.question.common.jdbc.JDBCTemplate.*;

public class PostService {

    private final PostDAO postDAO;

    public PostService(){
        postDAO = new PostDAO();
    }

    public int insertPost(PostDTO board) {

        Connection con = getConnection();

        int result = postDAO.insertPost(con, board);  // 작업이 성공 했는지 안했는지 결과값이다!! 1 반환 = 한 개의 행이 삽입되었다 라는 뜻!, 0 반환 = 삽입된 행 없다는뜻이고, 실패한경우이다!
        if(result > 0){
            commit(con);
        }else {
            rollback(con);
        }
        close(con);
        return result;
    }

    public List<PostDTO> selectAllPost() {

        Connection con = getConnection();

        List<PostDTO> postList = postDAO.selectAllPost(con);

        close(con);

        return postList;

    }

    public PostDTO selectOneId(int id){

        Connection con = getConnection();

        PostDTO postDTO = postDAO.selectOnePost(con, id);

        close(con);

        return postDTO;
    }

    public int updatePost(PostDTO board) {

        Connection con = getConnection();

        int result = postDAO.updatePost(con, board);
        if(result > 0){
            commit(con);
        }else {
            rollback(con);
        }
        close(con);
        return result;
    }

    public int deletePost(int id) {

        Connection con = getConnection();

        int result = postDAO.deletePost(con, id);
        if(result > 0){
            commit(con);
        }else {
            rollback(con);
        }
        close(con);
        return result;
    }

}
