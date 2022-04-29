package com.dzqc.domain;

import java.util.Date;

/**
 * 新闻实体类
 */
public class News {
    private Integer nid; //新闻id
    private Integer ntid; //主题id
    private String ntitle; //新闻标题
    private String nauthor; //新闻作者
    private Date ncreateDate; //新闻发布时间
    private String npicPath; //图片保存地址
    private String ncontent; //新闻内容
    private Date nmodifyDate; //新闻修改时间
    private String nsummary; //新闻摘要

    public News(){}

    public News(Integer nid, Integer ntid, String ntitle, String nauthor, String ncontent, Date nmodifyDate, String nsummary) {
        this.nid = nid;
        this.ntid = ntid;
        this.ntitle = ntitle;
        this.nauthor = nauthor;
        this.ncontent = ncontent;
        this.nmodifyDate = nmodifyDate;
        this.nsummary = nsummary;
    }

    public News(Integer ntid, String ntitle, String nauthor,Date ncreateDate,String npicPath, String ncontent, Date nmodifyDate, String nsummary) {
        this.ntid = ntid;
        this.ntitle = ntitle;
        this.nauthor = nauthor;
        this.ncreateDate = ncreateDate;
        this.npicPath = npicPath;
        this.ncontent = ncontent;
        this.nmodifyDate = nmodifyDate;
        this.nsummary = nsummary;
    }
    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public Integer getNtid() {
        return ntid;
    }

    public void setNtid(Integer ntid) {
        this.ntid = ntid;
    }

    public String getNauthor() {
        return nauthor;
    }

    public void setNauthor(String nauthor) {
        this.nauthor = nauthor;
    }

    public Date getNcreateDate() {
        return ncreateDate;
    }

    public void setNcreateDate(Date ncreateDate) {
        this.ncreateDate = ncreateDate;
    }

    public String getNtitle() {
        return ntitle;
    }

    public void setNtitle(String ntitle) {
        this.ntitle = ntitle;
    }

    public String getNpicPath() {
        return npicPath;
    }

    public void setNpicPath(String npicPath) {
        this.npicPath = npicPath;
    }

    public String getNcontent() {
        return ncontent;
    }

    public void setNcontent(String ncontent) {
        this.ncontent = ncontent;
    }

    public Date getNmodifyDate() {
        return nmodifyDate;
    }

    public void setNmodifyDate(Date nmodifyDate) {
        this.nmodifyDate = nmodifyDate;
    }

    public String getNsummary() {
        return nsummary;
    }

    public void setNsummary(String nsummary) {
        this.nsummary = nsummary;
    }
}
