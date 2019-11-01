package com.nchu.ruanko.iwork.domain.entity;

import java.util.Date;

public class Appraise {
    private String appraiseUid;
    private User user;
    private Date appDate;
    private String appResult;
    private String appContent;
    private String remark;

    public String getAppraiseUid() {
        return appraiseUid;
    }

    public void setAppraiseUid(String appraiseUid) {
        this.appraiseUid = appraiseUid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getAppDate() {
        return appDate;
    }

    public void setAppDate(Date appDate) {
        this.appDate = appDate;
    }

    public String getAppResult() {
        return appResult;
    }

    public void setAppResult(String appResult) {
        this.appResult = appResult;
    }

    public String getAppContent() {
        return appContent;
    }

    public void setAppContent(String appContent) {
        this.appContent = appContent;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Appraise{" +
                "appraiseUid='" + appraiseUid + '\'' +
                ", user=" + user +
                ", appDate=" + appDate +
                ", appResult='" + appResult + '\'' +
                ", appContent='" + appContent + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
