package com.ohgiraffers.mvc.employee.model.service;

import com.ohgiraffers.mvc.employee.model.dao.EmployeeDAO;
import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import static com.ohgiraffers.mvc.common.jdbc.JDBCTemplate.close;
import static com.ohgiraffers.mvc.common.jdbc.JDBCTemplate.getConnection;

public class EmployeeService {

    private final EmployeeDAO empDAO;

    public EmployeeService(){
        empDAO = new EmployeeDAO();
    }

    public EmployeeDTO selectOneEmpById(String empId) {

        Connection con = getConnection();

        EmployeeDTO selectEmp = empDAO.selectEmpById(con, empId);

        close(con);

        return selectEmp;
    }


    public List<EmployeeDTO> EmpList() {
        Connection con = getConnection();

        List<EmployeeDTO> empList = empDAO.EmpList(con);

        close(con);
        return empList;
    }


}