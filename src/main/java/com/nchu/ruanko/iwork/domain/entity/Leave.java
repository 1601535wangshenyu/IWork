package com.nchu.ruanko.iwork.domain.entity;

import java.util.Date;

public class Leave {
    private String leaveId;
    private User applyPerson;
    private Date applyDate;
    private String applyReason;
    private Leavetype leavetype;
    private Date startTime;
    private Date endTime;
    private String leaveTime;
    private Date approveDate;
    private User approver;
    private String approveResult;
    private int state;

    public String getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(String leaveId) {
        this.leaveId = leaveId;
    }

    public User getApplyPerson() {
        return applyPerson;
    }

    public void setApplyPerson(User applyPerson) {
        this.applyPerson = applyPerson;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getApplyReason() {
        return applyReason;
    }

    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason;
    }

    public Leavetype getLeavetype() {
        return leavetype;
    }

    public void setLeavetype(Leavetype leavetype) {
        this.leavetype = leavetype;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(String leaveTime) {
        this.leaveTime = leaveTime;
    }

    public Date getApproveDate() {
        return approveDate;
    }

    public void setApproveDate(Date approveDate) {
        this.approveDate = approveDate;
    }

    public User getApprover() {
        return approver;
    }

    public void setApprover(User approver) {
        this.approver = approver;
    }

    public String getApproveResult() {
        return approveResult;
    }

    public void setApproveResult(String approveResult) {
        this.approveResult = approveResult;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Leave{" +
                "leaveId='" + leaveId + '\'' +
                ", applyPerson=" + applyPerson +
                ", applyDate=" + applyDate +
                ", applyReason='" + applyReason + '\'' +
                ", leavetype=" + leavetype +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", leaveTime='" + leaveTime + '\'' +
                ", approveDate=" + approveDate +
                ", approver=" + approver +
                ", approveResult='" + approveResult + '\'' +
                ", state=" + state +
                '}';
    }
}
