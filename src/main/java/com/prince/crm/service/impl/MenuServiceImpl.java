package com.prince.crm.service.impl;

import com.prince.crm.domain.Menu;
import com.prince.crm.mapper.MenuMapper;
import com.prince.crm.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Prince Chen
 * @Description:
 * @Date: Create in 2019/9/22 16:56
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuDao;


    @Override
    public List<Menu> queryForMenu() {
        return menuDao.queryForMenu();
    }
}
