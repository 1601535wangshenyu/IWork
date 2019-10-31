package com.nchu.ruanko.iwork.domain.entity;

public class Department {
    private Integer departmentUid;
    private String name;
    private Department parentDepartment;
    private String path;
    private Integer enabled;
    private Integer isParent;

    public Integer getDepartmentUid() {
        return departmentUid;
    }

    public void setDepartmentUid(Integer departmentUid) {
        this.departmentUid = departmentUid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getParentDepartment() {
        return parentDepartment;
    }

    public void setParentDepartment(Department parentDepartment) {
        this.parentDepartment = parentDepartment;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public Integer getIsParent() {
        return isParent;
    }

    public void setIsParent(Integer isParent) {
        this.isParent = isParent;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentUid=" + departmentUid +
                ", name='" + name + '\'' +
                ", parentDepartment=" + parentDepartment +
                ", path='" + path + '\'' +
                ", enabled=" + enabled +
                ", isParent=" + isParent +
                '}';
    }
}
