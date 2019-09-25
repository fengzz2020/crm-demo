package com.prince.crm.service.impl;

import com.prince.crm.domain.Employee;
import com.prince.crm.mapper.EmployeeMapper;
import com.prince.crm.page.EmployeeQueryResult;
import com.prince.crm.query.EmployeeQueryObject;
import com.prince.crm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @Author: Prince Chen
 * @Description:
 * @Date: Create in 2019/9/22 14:14
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeDao;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return employeeDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Employee record) {
        int rows = employeeDao.insert(record);
        return rows;
    }

    @Override
    public Employee selectByPrimaryKey(Long id) {
        return employeeDao.selectByPrimaryKey(id);
    }

    @Override
    public List<Employee> selectAll() {
        return employeeDao.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Employee record) {
        return employeeDao.updateByPrimaryKey(record);
    }

    @Override
    public Employee getUserForLogin(String username, String password) {
        return employeeDao.getUserForLogin(username, password);
    }

    @Override
    public EmployeeQueryResult getEmployeeList(EmployeeQueryObject queryObject) {

        // 1. 查询记录总数
        Integer totalEmployees = employeeDao.getTotalEmployees(queryObject);

        if (totalEmployees == null) {
            return new EmployeeQueryResult(0, Collections.EMPTY_LIST);
        }

        // 2. 如果有记录则查询列表
        List<Employee> employeeList = employeeDao.getEmployeeList(queryObject);

        return new EmployeeQueryResult(totalEmployees, employeeList);
    }

    @Override
    public void updateState(Long id) {
        employeeDao.updateState(id);
    }
}
