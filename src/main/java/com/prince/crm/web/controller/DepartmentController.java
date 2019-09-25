package com.prince.crm.web.controller;

import com.prince.crm.domain.Department;
import com.prince.crm.domain.Employee;
import com.prince.crm.service.DepartmentService;
import com.prince.crm.util.UserContext;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * 部门相关接口
 *
 * @Author: Prince Chen
 * @Description:
 * @Date: Create in 2019/9/22 22:10
 */
@Controller
public class DepartmentController {
    private static final Logger logger = Logger.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;

    /**
     * 查询部门（id, name）列表
     *
     * @return
     */
    @RequestMapping("/department_queryForEmployee")
    @ResponseBody
    public List<Department> getDepartmentList(HttpSession session) {
        Employee curUser = (Employee) session.getAttribute(UserContext.USER_SESSION);
        logger.info("/department_queryForEmployee ===> 用户[" + curUser.getUsername() + "]查询部门列表");
        return departmentService.getDepartmentIdNames();
    }
}
