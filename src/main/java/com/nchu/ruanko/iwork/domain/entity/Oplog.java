package com.nchu.ruanko.iwork.domain.entity;

import java.util.Date;

public class Oplog {
    private String oplogUid;
    private Date addDate;
    private String operate;
    private User user;

    public String getOplogUid() {
        return oplogUid;
    }

    public void setOplogUid(String oplogUid) {
        this.oplogUid = oplogUid;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Oplog{" +
                "oplogUid='" + oplogUid + '\'' +
                ", addDate=" + addDate +
                ", operate='" + operate + '\'' +
                ", user=" + user +
                '}';
    }
}
