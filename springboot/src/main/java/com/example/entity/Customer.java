package com.example.entity;


/**
 * 客服聊天
 */
public class Customer {
    /** ID */
    private Integer id;
    /** 用户编号 */
    private String userId;
    /** 聊天内容 */
    private String content;
    /** 接收人 */
    private String acceptId;
    /** 发送时间 */
    private String time;
    /** 发送人头像 */
    private String UserImg;
    /** 发送人名称 */
    private String UserName;
    /** 发送人名称 */
    private String acceptName;

    public String getAcceptName() {
        return acceptName;
    }

    public void setAcceptName(String acceptName) {
        this.acceptName = acceptName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserImg() {
        return UserImg;
    }

    public void setUserImg(String userImg) {
        UserImg = userImg;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAcceptId() {
        return acceptId;
    }

    public void setAcceptId(String acceptId) {
        this.acceptId = acceptId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}