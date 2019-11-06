package com.nchu.ruanko.iwork.domain.entity;

import java.util.Date;

public class Adjustsalary {
    private String adjustsalaryUid;
    private User user;
    private Date asDate;
    private Salary beforeSalary;
    private Salary afterSalary;
    private String reason;
    private String remark;

    public String getAdjustsalaryUid() {
        return adjustsalaryUid;
    }

    public void setAdjustsalaryUid(String adjustsalaryUid) {
        this.adjustsalaryUid = adjustsalaryUid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getAsDate() {
        return asDate;
    }

    public void setAsDate(Date asDate) {
        this.asDate = asDate;
    }

    public Salary getBeforeSalary() {
        return beforeSalary;
    }

    public void setBeforeSalary(Salary beforeSalary) {
        this.beforeSalary = beforeSalary;
    }

    public Salary getAfterSalary() {
        return afterSalary;
    }

    public void setAfterSalary(Salary afterSalary) {
        this.afterSalary = afterSalary;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Adjustsalary{" +
                "adjustsalaryUid='" + adjustsalaryUid + '\'' +
                ", user=" + user +
                ", asDate=" + asDate +
                ", beforeSalary=" + beforeSalary +
                ", afterSalary=" + afterSalary +
                ", reason='" + reason + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
