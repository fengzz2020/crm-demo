package com.prince.crm.service;

import com.prince.crm.domain.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * @Author: Prince Chen
 * @Description:
 * @Date: Create in 2019/9/22 14:16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void testInsert() {
        Employee emp = new Employee();
        emp.setUsername("chensf");
        emp.setEmail("chen@qq.com");
        emp.setInputtime(new Date());
        employeeService.insert(emp);
    }
}
