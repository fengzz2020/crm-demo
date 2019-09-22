package com.prince.crm.domain;

public class Department {
    private Long id;

    private String sn;

    private String name;

    private Long manangerId;

    private Long parentId;

    private Boolean state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getManangerId() {
        return manangerId;
    }

    public void setManangerId(Long manangerId) {
        this.manangerId = manangerId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", sn='" + sn + '\'' +
                ", name='" + name + '\'' +
                ", manangerId=" + manangerId +
                ", parentId=" + parentId +
                ", state=" + state +
                '}';
    }
}