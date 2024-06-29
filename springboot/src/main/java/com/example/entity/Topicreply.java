package com.example.entity;


/**
 * 话题回复信息
 */
public class Topicreply {
    /** ID */
    private Integer id;
    /** 话题编号 */
    private Integer topicId;
    /** 留言用户编号 */
    private Integer userId;
    /** 留言内容 */
    private String content;
    /** 留言时间 */
    private String time;

    /** 用户名称 */
    private String userName;
    /** 用户头像 */
    private String userImg;
    /** 话题标题 */
    private String topicTitle;

    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}