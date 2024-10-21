<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시글 작성</title>
</head>
<body>
<h1>새 게시글 작성</h1>
<form action="newBoard" method="post">
    제목: <input type="text" name="title" required><br>
    내용: <textarea name="content" required></textarea><br>
    <input type="submit" value="작성하기">
</form>
</body>
</html>
