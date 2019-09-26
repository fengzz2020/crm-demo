package com.prince.crm.mapper;

import com.prince.crm.domain.EmpRole;
import java.util.List;

public interface EmpRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(EmpRole record);

    EmpRole selectByPrimaryKey(Long id);

    List<EmpRole> selectAll();

    int updateByPrimaryKey(EmpRole record);
}