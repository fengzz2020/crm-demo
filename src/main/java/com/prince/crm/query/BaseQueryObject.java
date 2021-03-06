package com.prince.crm.query;

/**
 * @Description 查询基类
 */
public class BaseQueryObject {
    /**
     * 当前页码
     */
    private Integer page;

    /**
     * 每页的记录数
     */
    private Integer rows;

    /**
     * 关键词，用于条件查询
     */
    private String keyWord;

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    /**
     * 这里的getStart方法，传入mapper.xml后就等价于一个start变量。（为啥呢？？）
     *
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
