<%--
  Created by IntelliJ IDEA.
  User: 803-13
  Date: 2024-10-16
  Time: 오후 3:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인 페이지</title>
</head>
<body>
<h1>로그인 페이지</h1>
<br/>

<form action="login" method="post">
    <label>User ID</label>
    <input type="text" name="userId" placeholder="User ID" required/>
    <input type="password" name="password" placeholder="Password" required/>
    <button type="submit">로그인</button>
</form>

<%=request.getAttribute("errorMessage") !=null ? request.getAttribute("errorMessage") : ""%>

<a href=signup.jsp>가입하기</a>
</body>
</html>
