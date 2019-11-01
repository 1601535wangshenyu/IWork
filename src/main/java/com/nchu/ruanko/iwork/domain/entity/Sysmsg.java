package com.nchu.ruanko.iwork.domain.entity;

public class Sysmsg {
    private String sysmsgUid;
    private Msgcontent msgcontent;
    private int type;
    private User user;
    private int state;

    public String getSysmsgUid() {
        return sysmsgUid;
    }

    public void setSysmsgUid(String sysmsgUid) {
        this.sysmsgUid = sysmsgUid;
    }

    public Msgcontent getMsgcontent() {
        return msgcontent;
    }

    public void setMsgcontent(Msgcontent msgcontent) {
        this.msgcontent = msgcontent;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Sysmsg{" +
                "sysmsgUid='" + sysmsgUid + '\'' +
                ", msgcontent=" + msgcontent +
                ", type=" + type +
                ", user=" + user +
                ", state=" + state +
                '}';
    }
}
