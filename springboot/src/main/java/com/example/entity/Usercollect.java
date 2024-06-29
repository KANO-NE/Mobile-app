package com.example.entity;


/**
 * 用户关注
 */
public class Usercollect {
    /** ID */
    private Integer id;
    /** 用户编号 */
    private Integer userId;
    /** 关注对象编号 */
    private Integer targetId;
    /** 关注时间 */
    private String time;

    /** 用户名称 */
    private String userName;
    /** 用户头像 */
    private String userImg;

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}