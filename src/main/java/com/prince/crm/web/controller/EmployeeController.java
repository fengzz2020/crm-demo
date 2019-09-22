package com.prince.crm.web.controller;

import com.prince.crm.domain.Employee;
import com.prince.crm.page.EmployeeQueryResult;
import com.prince.crm.query.EmployeeQueryObject;
import com.prince.crm.service.EmployeeService;
import com.prince.crm.util.UserSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Prince Chen
 * @Description:
 * @Date: Create in 2019/9/22 14:50
 */
@Controller
public class EmployeeController {
    private static Logger logger = Logger.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/login")
    @ResponseBody
    public Map<String, Object> login(String username, String password, HttpSession session) {
        Map<String, Object> result = new HashMap<>();
        Employee employee = employeeService.getUserForLogin(username, password);

        if (employee != null) {
            result.put("success", true);
            result.put("msg", "登录成功");
            session.setAttribute(UserSession.USER_SESSION, employee);
            logger.info("/login ===> " + employee.getUsername() + "登录成功");
        } else {
            result.put("success", false);
            result.put("msg", "账号或密码错误");
            logger.info("/login ===> 用户{" + username + ": " + password +  "}登录失败！");
        }

        return result;
    }

    @RequestMapping("/employee_list")
    @ResponseBody
    public EmployeeQueryResult queryEmployList(EmployeeQueryObject queryObject) {
        EmployeeQueryResult list = employeeService.getEmployeeList(queryObject);

        return list;
    }


}
