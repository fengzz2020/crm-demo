package com.prince.crm.domain;

import java.util.Date;

public class Log {
    private Long id;

    private Employee opuser;

    private Date optime;

    private String opip;

    private String func;

    private String params;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getOpuser() {
        return opuser;
    }

    public void setOpuser(Employee opuser) {
        this.opuser = opuser;
    }

    public Date getOptime() {
        return optime;
    }

    public void setOptime(Date optime) {
        this.optime = optime;
    }

    public String getOpip() {
        return opip;
    }

    public void setOpip(String opip) {
        this.opip = opip == null ? null : opip.trim();
    }

    public String getFunc() {
        return func;
    }

    public void setFunc(String func) {
        this.func = func == null ? null : func.trim();
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params == null ? null : params.trim();
    }
}