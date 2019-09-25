package com.prince.crm.service;

import com.prince.crm.domain.Log;

import java.util.List;

public interface LogService {
    int deleteByPrimaryKey(Long id);

    int insert(Log record);

    Log selectByPrimaryKey(Long id);

    List<Log> selectAll();

    int updateByPrimaryKey(Log record);
}