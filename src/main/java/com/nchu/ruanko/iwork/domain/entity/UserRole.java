package com.nchu.ruanko.iwork.domain.entity;

public class UserRole {
    private String userRoleUid;
    private User user;
    private Role role;
    private String rtime;

    public String getUserRoleUid() {
        return userRoleUid;
    }

    public void setUserRoleUid(String userRoleUid) {
        this.userRoleUid = userRoleUid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getRtime() {
        return rtime;
    }

    public void setRtime(String rtime) {
        this.rtime = rtime;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "userRoleUid='" + userRoleUid + '\'' +
                ", user=" + user +
                ", role=" + role +
                ", rtime='" + rtime + '\'' +
                '}';
    }
}
