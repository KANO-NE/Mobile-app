package com.example.entity;


import java.io.Serializable;

/**
 * 用户信息
 */
public class User extends Account implements Serializable {
    private static final long serialVersionUID = 1L;
    /** ID */
    private Integer id;
    /** 用户账号 */
    private String username;
    /** 用户密码 */
    private String password;
    /** 用户名称 */
    private String name;
    /** 用户介绍 */
    private String introduce;
    /** 出生日期 */
    private String birthday;
    /** 电话 */
    private String phone;
    /** 角色 */
    private String role;
    /** 性别 */
    private String gender;
    /** 头像 */
    private String img;
    /** 禁用状态 */
    private String status;
    /** 最后登录时间 */
    private String lasttime;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String getRole() {
        return role;
    }

    @Override
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String getImg() {
        return img;
    }

    @Override
    public void setImg(String img) {
        this.img = img;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLasttime() {
        return lasttime;
    }

    public void setLasttime(String lasttime) {
        this.lasttime = lasttime;
    }
}