<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시판</title>
</head>
<body>
<h1>게시판</h1>
<a href="newBoard">새 게시글 작성</a>

<h2>게시글 목록</h2>

    <c:if test="${empty postList}">
        <p>게시글이 없습니다.</p>
    </c:if>
    <c:if test="${not empty postList}">
    <table style="margin-left: 100px">
        <tr>
            <th>ID</th>
            <th>제목</th>
            <th>작업</th>
        </tr>
        <c:forEach var="post" items="${postList}">
            <tr>
                <td>${post.id}</td>
                <td><a href="detail?id=${post.id}">${post.title}</a></td>
                <td>
                    <a href="edit?id=${post.id}">수정</a>
                    <a href="delete?id=${post.id}">삭제</a>
                </td>
            </tr>
        </c:forEach>
        </c:if>
    </table>
</body>
</html>
