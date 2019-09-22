package com.prince.crm.page;

import com.prince.crm.domain.Employee;

import java.util.List;

/**
 * 封装查询员工列表时返回的结果
 * @Author: Prince Chen
 * @Description:
 * @Date: Create in 2019/9/22 18:53
 */
public class EmployeeQueryResult {
    /**
     * 查询出来的总的记录数
     */
    private Integer total;

    /**
     * 结果列表
     */
    private List<Employee> rows;

    public EmployeeQueryResult(Integer total, List<Employee> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Employee> getRows() {
        return rows;
    }

    public void setRows(List<Employee> rows) {
        this.rows = rows;
    }
}
