package com.nchu.ruanko.iwork.domain.entity;

public class RoleMeau {
    private String roleMeauUid;
    private Menu menu;
    private Role role;

    public String getRoleMeauUid() {
        return roleMeauUid;
    }

    public void setRoleMeauUid(String roleMeauUid) {
        this.roleMeauUid = roleMeauUid;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "RoleMeau{" +
                "roleMeauUid='" + roleMeauUid + '\'' +
                ", menu=" + menu +
                ", role=" + role +
                '}';
    }
}
