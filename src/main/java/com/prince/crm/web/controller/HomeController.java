package com.prince.crm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Prince Chen
 * @Description:
 * @Date: Create in 2019/9/22 16:33
 */
@Controller
public class HomeController {

    @RequestMapping("/index")
    public String home() {
        return "index";
    }
}
