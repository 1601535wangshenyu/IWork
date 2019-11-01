package com.nchu.ruanko.iwork.domain.entity;

public class Role {
    private String roleUid;
    private String name;
    private String nameZh;
    private String description;

    public String getRoleUid() {
        return roleUid;
    }

    public void setRoleUid(String roleUid) {
        this.roleUid = roleUid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameZh() {
        return nameZh;
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleUid='" + roleUid + '\'' +
                ", name='" + name + '\'' +
                ", nameZh='" + nameZh + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
