package com.example.entity;


/**
 * 海报
 */
public class Banner {
    /** ID */
    private Integer id;
    /** 标题 */
    private String title;
    /** 图片地址 */
    private String img;
    /** 跳转地址 */
    private String url;
    /** 发布者 */
    private String username;
    /** 发布时间 */
    private String time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}