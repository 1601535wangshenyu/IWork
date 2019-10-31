package com.nchu.ruanko.iwork.domain.entity;

public class EmployeeState {
    private Integer employeeStateId;
    private String  employeeState;
    private String  remark;

    public Integer getEmployeeStateId() {
        return employeeStateId;
    }

    public void setEmployeeStateId(Integer employeeStateId) {
        this.employeeStateId = employeeStateId;
    }

    public String getEmployeeState() {
        return employeeState;
    }

    public void setEmployeeState(String employeeState) {
        this.employeeState = employeeState;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "EmployeeState{" +
                "employeeStateId=" + employeeStateId +
                ", employeeState='" + employeeState + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
