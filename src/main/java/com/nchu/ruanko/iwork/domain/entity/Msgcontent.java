package com.nchu.ruanko.iwork.domain.entity;

import java.sql.Timestamp;

public class Msgcontent {
    private String msgcontentUid;
    private String title;
    private String message;
    private Timestamp createDate;

    public String getMsgcontentUid() {
        return msgcontentUid;
    }

    public void setMsgcontentUid(String msgcontentUid) {
        this.msgcontentUid = msgcontentUid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Msgcontent{" +
                "msgcontentUid='" + msgcontentUid + '\'' +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
