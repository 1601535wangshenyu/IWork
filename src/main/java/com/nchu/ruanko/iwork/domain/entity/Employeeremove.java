package com.nchu.ruanko.iwork.domain.entity;

import java.util.Date;

public class Employeeremove {
    private String employeeremoveUid;
    private User user;
    private int afterDep;
    private int afterJob;
    private int beforeDep;
    private int beforeJob;
    private Date removeDate;
    private String reason;
    private String remark;

    public String getEmployeeremoveUid() {
        return employeeremoveUid;
    }

    public void setEmployeeremoveUid(String employeeremoveUid) {
        this.employeeremoveUid = employeeremoveUid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getAfterDep() {
        return afterDep;
    }

    public void setAfterDep(int afterDep) {
        this.afterDep = afterDep;
    }

    public int getAfterJob() {
        return afterJob;
    }

    public void setAfterJob(int afterJob) {
        this.afterJob = afterJob;
    }

    public int getBeforeDep() {
        return beforeDep;
    }

    public void setBeforeDep(int beforeDep) {
        this.beforeDep = beforeDep;
    }

    public int getBeforeJob() {
        return beforeJob;
    }

    public void setBeforeJob(int beforeJob) {
        this.beforeJob = beforeJob;
    }

    public Date getRemoveDate() {
        return removeDate;
    }

    public void setRemoveDate(Date removeDate) {
        this.removeDate = removeDate;
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
        return "Employeeremove{" +
                "employeeremoveUid='" + employeeremoveUid + '\'' +
                ", user=" + user +
                ", afterDep=" + afterDep +
                ", afterJob=" + afterJob +
                ", beforeDep=" + beforeDep +
                ", beforeJob=" + beforeJob +
                ", removeDate=" + removeDate +
                ", reason='" + reason + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
