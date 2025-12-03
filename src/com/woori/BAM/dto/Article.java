package com.woori.BAM.dto;


public class Article {
    private int id;
    private String title;
    private String body;
    private String regDate;
    private int viewCnt;

//        Article() {}

    public Article(int id, String title, String body, String regDate, int viewCnt) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.regDate = regDate;
        this.viewCnt = viewCnt;
    }

    public void increaseViewCnt() {
        this.viewCnt++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public int getViewCnt() {
        return viewCnt;
    }

    public void setViewCnt(int viewCnt) {
        this.viewCnt = viewCnt;
    }
}
