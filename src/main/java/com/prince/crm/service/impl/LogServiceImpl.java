package com.prince.crm.service.impl;

import com.prince.crm.domain.Log;
import com.prince.crm.mapper.LogMapper;
import com.prince.crm.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Prince Chen
 * @Description:
 * @Date: Create in 2019/9/25 22:48
 */
@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogMapper logMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public int insert(Log record) {
        return logMapper.insert(record);
    }

    @Override
    public Log selectByPrimaryKey(Long id) {
        return null;
    }

    @Override
    public List<Log> selectAll() {
        return null;
    }

    @Override
    public int updateByPrimaryKey(Log record) {
        return 0;
    }
}
