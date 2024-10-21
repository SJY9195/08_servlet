<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="edit" method="post">
        <input type="hidden" value="${requestScope.postDTO.id}" name="id"><br>
        제목 : <input type="text" value="${requestScope.postDTO.title}" name="title"><br>
        내용 : <textarea name="content">${requestScope.postDTO.content}</textarea><br>
            <button type="submit">수정하기</button>
    </form>

<a href="selectAll">돌아가기</a>
</body>
</html>
