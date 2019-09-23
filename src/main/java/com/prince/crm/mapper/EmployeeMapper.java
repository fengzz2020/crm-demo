package com.prince.crm.mapper;

import com.prince.crm.domain.Employee;
import com.prince.crm.query.EmployeeQueryObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Employee record);

    Employee selectByPrimaryKey(Long id);

    List<Employee> selectAll();

    int updateByPrimaryKey(Employee record);


    Employee getUserForLogin(@Param("username") String username, @Param("password") String password);

    Integer getTotalEmployees();

    List<Employee> getEmployeeList(EmployeeQueryObject queryObject);

    void updateState(Long id);
}