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
