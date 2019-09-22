package com.prince.crm.service;

import com.prince.crm.domain.Employee;
import com.prince.crm.page.EmployeeQueryResult;
import com.prince.crm.query.EmployeeQueryObject;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {
    int deleteByPrimaryKey(Long id);

    int insert(Employee record);

    Employee selectByPrimaryKey(Long id);

    List<Employee> selectAll();

    int updateByPrimaryKey(Employee record);

    Employee getUserForLogin(String username, String password);

    EmployeeQueryResult getEmployeeList(EmployeeQueryObject queryObject);
}