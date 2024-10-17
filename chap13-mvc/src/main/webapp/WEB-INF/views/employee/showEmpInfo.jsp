<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <jsp:include page="../common/header.jsp"/>

    사원 번호 : ${requestScope.selectEmp.empId} <br/>     <!--requestScope : req.getAttribute()의 축약버전-->
    사원 명 : ${requestScope.selectEmp.empName} <br/>
    부서 코드 : ${requestScope.selectEmp.deptCode} <br/>
    직급 코드 : ${requestScope.selectEmp.jobCode} <br/>
    급여 : ${requestScope.selectEmp.salary}

</body>
</html>
