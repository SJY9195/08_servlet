<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
<head>
    <title>게시글 작성</title>
</head>
<body>
<h1>게시글 작성</h1>


<form action='writepost' method='post'>
    제목: <input type='text' name='title' ><br>
    내용: <textarea name='content'></textarea><br>
    <input type='submit' value='작성하기'>
</form>
</body>
</html>