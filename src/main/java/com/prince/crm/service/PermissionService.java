package com.prince.crm.service;

import com.prince.crm.domain.Permission;

import java.util.List;

/**
 * @Description TODO
 * @Author prince Chen
 * @Date 2019/11/16 21:29
 */

public interface PermissionService {
    int deleteByPrimaryKey(Long id);

    int insert(Permission record);

    Permission selectByPrimaryKey(Long id);

    List<Permission> selectAll();

    int updateByPrimaryKey(Permission record);

    List<String> queryResourceById(Long id);
}
