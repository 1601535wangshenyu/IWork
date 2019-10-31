package com.nchu.ruanko.iwork.domain.entity;

import java.sql.Timestamp;

public class JobLevel {
    private String JobLevelUid;
    private String name;
    private String titleLevel;
    private Timestamp createDate;
    private int enabled;

    public String getJobLevelUid() {
        return JobLevelUid;
    }

    public void setJobLevelUid(String jobLevelUid) {
        JobLevelUid = jobLevelUid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitleLevel() {
        return titleLevel;
    }

    public void setTitleLevel(String titleLevel) {
        this.titleLevel = titleLevel;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "JobLevel{" +
                "JobLevelUid='" + JobLevelUid + '\'' +
                ", name='" + name + '\'' +
                ", titleLevel='" + titleLevel + '\'' +
                ", createDate=" + createDate +
                ", enabled=" + enabled +
                '}';
    }
}
