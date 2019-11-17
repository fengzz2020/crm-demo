package com.prince.crm.service.impl;

import com.prince.crm.domain.Permission;
import com.prince.crm.mapper.PermissionMapper;
import com.prince.crm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TODO
 * @Author prince Chen
 * @Date 2019/11/16 21:30
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionDao;


    @Override
    public int deleteByPrimaryKey(Long id) {
        return permissionDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Permission record) {
        return permissionDao.insert(record);
    }

    @Override
    public Permission selectByPrimaryKey(Long id) {
        return permissionDao.selectByPrimaryKey(id);
    }

    @Override
    public List<Permission> selectAll() {
        return permissionDao.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Permission record) {
        return permissionDao.updateByPrimaryKey(record);
    }

    @Override
    public List<String> queryResourceById(Long id) {
        return permissionDao.queryResourceById(id);
    }
}
