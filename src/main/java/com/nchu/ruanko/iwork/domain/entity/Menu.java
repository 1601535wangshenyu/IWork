package com.nchu.ruanko.iwork.domain.entity;

public class Menu {
    private String menuUid;
    private String url;
    private String path;
    private String component;
    private String name;
    private int keepAlive;
    private int requireAuth;
    private Menu parent;
    private int enabled;

    public String getMenuUid() {
        return menuUid;
    }

    public void setMenuUid(String menuUid) {
        this.menuUid = menuUid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(int keepAlive) {
        this.keepAlive = keepAlive;
    }

    public int getRequireAuth() {
        return requireAuth;
    }

    public void setRequireAuth(int requireAuth) {
        this.requireAuth = requireAuth;
    }

    public Menu getParent() {
        return parent;
    }

    public void setParent(Menu parent) {
        this.parent = parent;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuUid='" + menuUid + '\'' +
                ", url='" + url + '\'' +
                ", path='" + path + '\'' +
                ", component='" + component + '\'' +
                ", name='" + name + '\'' +
                ", keepAlive=" + keepAlive +
                ", requireAuth=" + requireAuth +
                ", parent=" + parent +
                ", enabled=" + enabled +
                '}';
    }
}
