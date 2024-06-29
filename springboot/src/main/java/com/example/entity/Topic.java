package com.example.entity;


/**
 * 今日话题
 */
public class Topic {
    /** ID */
    private Integer id;
    /** 标题 */
    private String title;
    /** 回复人数 */
    private Integer reply;
    /** 浏览次数 */
    private Integer num;
    /** 发布时间 */
    private String time;
    /** 发布人 */
    private String name;

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

    public Integer getReply() {
        return reply;
    }

    public void setReply(Integer reply) {
        this.reply = reply;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}