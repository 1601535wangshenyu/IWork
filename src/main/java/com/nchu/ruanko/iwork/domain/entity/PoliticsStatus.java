package com.nchu.ruanko.iwork.domain.entity;

public class PoliticsStatus {
    private String politicsStatusUId;
    private String name;

    public String getPoliticsStatusUId() {
        return politicsStatusUId;
    }

    public void setPoliticsStatusUId(String politicsStatusUId) {
        this.politicsStatusUId = politicsStatusUId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PoliticsStatus{" +
                "politicsStatusUId='" + politicsStatusUId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
