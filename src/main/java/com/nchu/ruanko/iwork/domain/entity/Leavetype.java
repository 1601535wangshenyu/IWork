package com.nchu.ruanko.iwork.domain.entity;

public class Leavetype {
    private int leavetypeId;
    private String leaveType;

    public int getLeavetypeId() {
        return leavetypeId;
    }

    public void setLeavetypeId(int leavetypeId) {
        this.leavetypeId = leavetypeId;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    @Override
    public String toString() {
        return "Leavetype{" +
                "leavetypeId=" + leavetypeId +
                ", leaveType='" + leaveType + '\'' +
                '}';
    }
}
