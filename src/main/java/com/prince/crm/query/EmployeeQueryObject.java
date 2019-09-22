package com.prince.crm.query;

/**
 * @Author: Prince Chen
 * @Description:
 * @Date: Create in 2019/9/22 18:54
 */
public class EmployeeQueryObject {
    /**
     * 当前页码
     */
    private Integer page;

    /**
     * 每页的记录数
     */
    private Integer rows;

    /**
     * 这里的getStart方法，传入mapper.xml后就等价于一个start变量。（为啥呢？？）
     * @return
     */
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
