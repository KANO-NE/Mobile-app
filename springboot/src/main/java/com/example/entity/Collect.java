package com.example.entity;


/**
 * 收藏
 */
public class Collect {
    /** ID */
    private Integer id;
    /** 收藏话题编号 */
    private Integer topicId;
    /** 收藏用户编号 */
    private Integer userId;
    /** 收藏时间 */
    private String time;
    /** 收藏话题 */
    private String topicTitle;
    /** 收藏用户名称 */
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}