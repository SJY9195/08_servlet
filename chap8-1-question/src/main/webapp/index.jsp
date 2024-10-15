<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>게시글</title>
</head>
<body>
<h1>게시글 작성</h1>
<br/>

<form action="board" method="post">
    <label for="title">제목:</label>
    <input type="text" id="title" name="title" ><br>
    <label for="content">내용:</label>
    <textarea id="content" name="content"></textarea><br>
    <input type="submit" value="작성하기">
</form>
</body>
</html>