<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
제목 : ${requestScope.postDTO.title}<br>
내용 : ${requestScope.postDTO.content}<br>

<a href="selectAll">돌아가기</a>

</body>
</html>
