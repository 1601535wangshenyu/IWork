package com.nchu.ruanko.iwork.domain.entity;

import java.util.Date;

public class Check {
    private String checkUid;
    private User user;
    private String siteposLat;
    private String siteposLng;
    private Date date;

    public String getCheckUid() {
        return checkUid;
    }

    public void setCheckUid(String checkUid) {
        this.checkUid = checkUid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSiteposLat() {
        return siteposLat;
    }

    public void setSiteposLat(String siteposLat) {
        this.siteposLat = siteposLat;
    }

    public String getSiteposLng() {
        return siteposLng;
    }

    public void setSiteposLng(String siteposLng) {
        this.siteposLng = siteposLng;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Check{" +
                "checkUid='" + checkUid + '\'' +
                ", user=" + user +
                ", siteposLat='" + siteposLat + '\'' +
                ", siteposLng='" + siteposLng + '\'' +
                ", date=" + date +
                '}';
    }
}
