package com.example.entity;


/**
 * 活动
 */
public class Activity {
    /** ID */
    private Integer id;
    /** 活动名称 */
    private String name;
    /** 活动介绍 */
    private String introduce;
    /** 活动图片 */
    private String img;
    /** 活动创建人 */
    private Integer userId;
    /** 活动规模 */
    private Integer num;
    /** 活动时间 */
    private String time;
    /** 活动类别 */
    private String type;

    /** 创建人名称 */
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

}