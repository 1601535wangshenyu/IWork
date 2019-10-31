package com.nchu.ruanko.iwork.domain.entity;

public class Nation {
    private Integer nationUid;
    private String name;

    public Integer getNationUid() {
        return nationUid;
    }

    public void setNationUid(Integer nationUid) {
        this.nationUid = nationUid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "nation{" +
                "nationUid='" + nationUid + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
