package com.nchu.ruanko.iwork.domain.entity;

public class Checkrule {
    private String checkruleUid;
    private String siteposLat;
    private String siteposLng;
    private float siteradius;

    public String getCheckruleUid() {
        return checkruleUid;
    }

    public void setCheckruleUid(String checkruleUid) {
        this.checkruleUid = checkruleUid;
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

    public float getSiteradius() {
        return siteradius;
    }

    public void setSiteradius(float siteradius) {
        this.siteradius = siteradius;
    }

    @Override
    public String toString() {
        return "Checkrule{" +
                "checkruleUid='" + checkruleUid + '\'' +
                ", siteposLat='" + siteposLat + '\'' +
                ", siteposLng='" + siteposLng + '\'' +
                ", siteradius=" + siteradius +
                '}';
    }
}
