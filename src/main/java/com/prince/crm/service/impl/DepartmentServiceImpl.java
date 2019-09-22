package com.prince.crm.service.impl;

import com.prince.crm.domain.Department;
import com.prince.crm.mapper.DepartmentMapper;
import com.prince.crm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Prince Chen
 * @Description:
 * @Date: Create in 2019/9/22 22:26
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentDao;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return departmentDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Department record) {
        return departmentDao.insert(record);
    }

    @Override
    public Department selectByPrimaryKey(Long id) {
        return departmentDao.selectByPrimaryKey(id);
    }

    @Override
    public List<Department> selectAll() {
        return departmentDao.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Department record) {
        return departmentDao.updateByPrimaryKey(record);
    }

    @Override
    public List<Department> getDepartmentIdNames() {
        return departmentDao.getDepartmentIdNames();
    }
}
