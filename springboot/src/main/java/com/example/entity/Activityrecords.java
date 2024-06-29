package com.example.entity;


/**
 * 活动记录
 */
public class Activityrecords {
    /** ID */
    private Integer id;
    /** 活动编号 */
    private Integer activityId;
    /** 用户编号 */
    private Integer userId;
    /** 加入时间 */
    private String time;

    /** 活动名称 */
    private String activityName;
    /** 活动头像 */
    private String activityImg;
    /** 活动介绍 */
    private String introduce;
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

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityImg() {
        return activityImg;
    }

    public void setActivityImg(String activityImg) {
        this.activityImg = activityImg;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
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