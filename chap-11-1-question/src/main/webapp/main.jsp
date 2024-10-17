<%--
  Created by IntelliJ IDEA.
  User: 803-13
  Date: 2024-10-16
  Time: 오후 5:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>메인 페이지</title>
</head>
<body>

<h1>환영합니다! <%= request.getAttribute("userId")%> 님!</h1>

<!-- 나의 오답<form action="main" method="post">

</form>-->

<a href="logout">로그아웃</a>
</body>
</html>