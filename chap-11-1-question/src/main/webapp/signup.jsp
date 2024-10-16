<%--
  Created by IntelliJ IDEA.
  User: 803-13
  Date: 2024-10-16
  Time: 오후 3:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입 페이지</title>
</head>
<body>
<h1>회원가입</h1>
<br/>

<form action="signup" method="post">
    <label>User ID</label>
    <input type="text" name="userId"/>
    <input type="password" name="password"/>
    <input type="text" name="email"/>
    <button type="submit">가입하기</button>
</form>

<a href=login.jsp>로그인화면</a>
</body>
</html>