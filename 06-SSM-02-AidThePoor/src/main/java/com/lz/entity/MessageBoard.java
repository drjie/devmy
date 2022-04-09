package com.lz.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class MessageBoard {
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private Long userId;

    private String username;

    private String content;

    private String reply;

    private String picture;

    private String replyPicture;

    private Boolean isdel;

    public void setIsdel(Boolean isdel) {
        this.isdel = isdel;
    }

    public Boolean getIsdel() {
        return isdel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getReply() {
        return reply;
    }

    public String getReplyPicture() {
        return replyPicture;
    }

    public void setReplyPicture(String replyPicture) {
        this.replyPicture = replyPicture == null ? null : replyPicture.trim();
    }
}