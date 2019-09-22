package com.prince.crm.service;

import com.prince.crm.domain.Department;

import java.util.List;

public interface DepartmentService {
    int deleteByPrimaryKey(Long id);

    int insert(Department record);

    Department selectByPrimaryKey(Long id);

    List<Department> selectAll();

    int updateByPrimaryKey(Department record);

    List<Department> getDepartmentIdNames();
}