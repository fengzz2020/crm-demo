package com.prince.crm.web.controller;

import com.prince.crm.domain.Menu;
import com.prince.crm.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: Prince Chen
 * @Description:
 * @Date: Create in 2019/9/22 16:33
 */
@Controller
public class HomeController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/index")
    public String home() {
        return "index";
    }

    @RequestMapping("/queryForMenu")
    @ResponseBody
    public List<Menu> queryForMenu() {
        return menuService.queryForMenu();
    }
}
