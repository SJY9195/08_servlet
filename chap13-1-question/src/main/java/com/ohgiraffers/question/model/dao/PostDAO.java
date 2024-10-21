package com.ohgiraffers.question.model.dao;

import com.ohgiraffers.question.common.config.ConfigLocation;
import com.ohgiraffers.question.model.dto.PostDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.ohgiraffers.question.common.jdbc.JDBCTemplate.close;

public class PostDAO {

    private final Properties prop;

    public PostDAO(){     //여기 DAO는 query문에 설정한 DTO를 넣어 주는 역할!!!
        prop = new Properties();
        try {
            prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "board-mapper.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int insertPost(Connection con, PostDTO board) {
       PreparedStatement pstmt = null;  //pstmt는 변수(매개변수)를 포함한 SQL 쿼리를 미리 준비해 두고 실행하는 객체다! 즉, 쿼리의 특정부분(? 부분)에 값을 넣을 수 있다.
                                        // 재료 선택하는 햄버거 가게랑 같다 (서브웨이)
                                        // rset은 쿼리를 실행한 결과를 담는 객체이다. 데이터베이스에서 조회(SELECT) 쿼리를 실행할 때, 결과를 저장하고 처리할 때 사용한다. 데이터베이스에서 조회한 결과를 rset에 담아서, 코드에서 그값을 사용할 수 있도록 해준다!
       int result = 0;                  // 즉, 레스토랑 트레이와 같다!

       String query = prop.getProperty("insertPost");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, board.getTitle());
            pstmt.setString(2, board.getContent());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(pstmt);
        }

        return result;

    }

    public List<PostDTO> selectAllPost(Connection con) {

        Statement stmt = null;    //stmt 는 SQL 쿼리에서 변수 없이 고정된 쿼리를 사용할 때 적합하다!!! (리스트에서 뿌려줄때)
        ResultSet rset = null;     // 햄버거가게에 있는 세트메뉴라 생각하면된다!

        List<PostDTO> postList = null;

        String query = prop.getProperty("selectAllPost");

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);
            postList = new ArrayList<>();
            while (rset.next()){
                PostDTO dto = new PostDTO();
                dto.setId(rset.getInt("ID"));
                dto.setTitle(rset.getString("TITLE"));
                dto.setContent(rset.getString("CONTENT"));
                System.out.println(dto);
                postList.add(dto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            close(rset);
            close(stmt);
        }
        return postList;
    }

    public PostDTO selectOnePost(Connection con, int id){

        PreparedStatement pstmt = null;
        ResultSet rset = null;

        PostDTO dto = null;

        String query = prop.getProperty("selectOnePost");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);  //1 → SQL 쿼리의 첫 번째 ? 자리에 id 값을 넣어 주겠다는 뜻!!
            rset = pstmt.executeQuery();
            System.out.println(rset);
            if(rset.next()){
                dto = new PostDTO();
                dto.setId(rset.getInt("ID"));
                dto.setTitle(rset.getString("TITLE"));
                dto.setContent(rset.getString("CONTENT"));
                System.out.println(dto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            close(rset);
            close(pstmt);
        }
        return dto;
    }

    public int updatePost(Connection con, PostDTO board) {  //board 매개변수 쓰는 이유 : board 객체의 메소드(입력한거받아오는기능)를 쓰기 위함!

        PreparedStatement pstmt = null;

        int result = 0;

        String query = prop.getProperty("updatePost");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, board.getTitle());
            pstmt.setString(2, board.getContent());
            pstmt.setInt(3, board.getId());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(pstmt);
        }

        return result;
    }

    public int deletePost(Connection con, int id) {

        PreparedStatement pstmt = null;

        int result = 0;

        String query = prop.getProperty("deletePost");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            close(pstmt);
        }
        return result;
    }

}
