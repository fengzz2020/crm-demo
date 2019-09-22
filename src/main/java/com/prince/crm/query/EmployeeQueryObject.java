package com.prince.crm.query;

/**
 * @Author: Prince Chen
 * @Description:
 * @Date: Create in 2019/9/22 18:54
 */
public class EmployeeQueryObject {
    private Integer page;
    private Integer rows;

    public Integer getStart() {
        return (page - 1) * rows;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
