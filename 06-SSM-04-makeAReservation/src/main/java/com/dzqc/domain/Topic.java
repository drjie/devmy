package com.dzqc.domain;

/**
 * 主题实体类
 */
public class Topic {
    private Integer tid;
    private String tname; //主题名称

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }
}
