package com.prince.crm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description 角色相关
 * @Author prince Chen
 * @Date 2019/11/17 13:15
 */
@Controller
public class RoleController {

    @RequestMapping("/role")
    public String index() {
        return "role";
    }
}
