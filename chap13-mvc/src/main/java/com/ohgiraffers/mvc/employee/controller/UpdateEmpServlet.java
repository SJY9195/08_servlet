package com.ohgiraffers.mvc.employee.controller;

import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;
import com.ohgiraffers.mvc.employee.model.service.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/employee/update")
public class UpdateEmpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empId = req.getParameter("empId");  // req.getParemeter가 받을 때는 무조건 String 이므로 형변환을 해줘야 한다!!
        java.sql.Date entDate = java.sql.Date.valueOf(req.getParameter("entDate")); //서비스에서 하나만 꺼내 올 empId처리해야함

        EmployeeService employeeService = new EmployeeService();
        EmployeeDTO emp = new EmployeeDTO();
        emp.setEmpId(Integer.parseInt(empId)); //이 ID는 굳이 service에서 받을 필요없다.(당연한말이지만 머리아플때 조심하자)
        emp.setEntDate(entDate);
        System.out.println(emp);
        int result = employeeService.updateEmp(emp);  // 서비스에서 받아온 updateEmp를 쓰는 코드!!

        String path = "";
        if(result > 0){
            path = "/WEB-INF/views/common/successPage.jsp";
            req.setAttribute("successCode","updateEmp");
        }else {
            path = "/WEB-INF/views/common/errorPage.jsp";
            req.setAttribute("errorCode","퇴사처리에 실패하셨습니다.");
        }

        req.getRequestDispatcher(path).forward(req, resp);

    }
}
