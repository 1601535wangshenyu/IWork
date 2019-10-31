package com.nchu.ruanko.iwork.domain.entity;

import java.sql.Timestamp;

public class Position {
    private String positionUid;
    private String name;
    private Timestamp createDate;
    private Integer enabled;

    public String getPositionUid() {
        return positionUid;
    }

    public void setPositionUid(String positionUid) {
        this.positionUid = positionUid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "Position{" +
                "positionUid='" + positionUid + '\'' +
                ", name='" + name + '\'' +
                ", createDate=" + createDate +
                ", enabled=" + enabled +
                '}';
    }
}
