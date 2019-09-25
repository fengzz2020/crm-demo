package com.prince.crm.web.controller;

import com.prince.crm.domain.Employee;
import com.prince.crm.page.EmployeeQueryResult;
import com.prince.crm.query.EmployeeQueryObject;
import com.prince.crm.service.EmployeeService;
import com.prince.crm.util.UserContext;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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

    /**
     * 登陆
     * @param username 用户名
     * @param password 密码
     * @param request 请求
     * @return 结果信息
     */
    @RequestMapping("/login")
    @ResponseBody
    public Map<String, Object> login(String username, String password, HttpServletRequest request) {
        // 将request设置到当前线程的ThreadLocal中，供后面的Log切面类使用
        UserContext.setLocalRequest(request);

        Map<String, Object> result = new HashMap<>();
        Employee employee = employeeService.getUserForLogin(username, password);

        if (employee != null) {
            result.put("success", true);
            result.put("msg", "登录成功");
            request.getSession().setAttribute(UserContext.USER_SESSION, employee);
            logger.info("/login ===> " + employee.getUsername() + "登录成功");
        } else {
            result.put("success", false);
            result.put("msg", "账号或密码错误");
            logger.info("/login ===> 用户{" + username + ": " + password + "}登录失败！");
        }

        return result;
    }

    /**
     * 查询员工列表
     *
     * @param queryObject 查询条件（分页）
     * @return 员工列表
     */
    @RequestMapping("/employee_list")
    @ResponseBody
    public EmployeeQueryResult queryEmployList(EmployeeQueryObject queryObject) {

        return employeeService.getEmployeeList(queryObject);
    }

    /**
     * 更新员工信息
     *
     * @param employee 员工信息
     */
    @RequestMapping("/employee_update")
    public Map<String, Object> updateEmployee(Employee employee) {
        HashMap<String, Object> result = new HashMap<>();
        try {
            employeeService.updateByPrimaryKey(employee);
            result.put("success", true);
            result.put("msg", "更新成功");
        } catch (Exception e) {
            logger.info("/employee_update ===> 更新员工信息异常：" + e);
            result.put("success", false);
            result.put("msg", "更新失败，请联系管理员");
        }

        return result;
    }

    /**
     * 增加一个新的员工
     *
     * @param employee 增加的员工信息
     */
    @RequestMapping("/employee_save")
    @ResponseBody
    public Map<String, Object> addEmployee(Employee employee, HttpSession session) {
        HashMap<String, Object> result = new HashMap<>();
        Employee curUser = (Employee) session.getAttribute(UserContext.USER_SESSION);
        logger.info("/employee_save ===> 管理员[" + curUser.getUsername() + "]在新增员工");

        try {
            employee.setPassword("666666");
            employee.setState(true);
            employee.setAdmin(false);
            employeeService.insert(employee);
            result.put("success", true);
            result.put("msg", "保存成功");
        } catch (Exception e) {
            logger.error("/employee_save ===> 新增员工异常：" + e );
            result.put("success", false);
            result.put("msg", "保存失败，请联系管理员");
        }

        return result;
    }

    /**
     * 员工离职
     *
     * @param id 员工id
     * @param session 会话
     * @return 结果信息
     */
    @RequestMapping("/employee_delete")
    @ResponseBody
    public Map<String, Object> updateState(Long id, HttpSession session) {
        HashMap<String, Object> result = new HashMap<>();
        Employee curUser = (Employee) session.getAttribute(UserContext.USER_SESSION);
        try {
            employeeService.updateState(id);
            logger.info("管理员【" + curUser.getUsername() + "】将员工【" + id + "】状态更新为离职");
            result.put("success", true);
            result.put("msg", "修改成功");
        } catch (Exception e) {
            result.put("success", false);
            result.put("msg", "更新异常，请联系管理员");
            logger.error("/employee_delete ===> " + e);
        }

        return result;
    }


}
