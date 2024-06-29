package com.example.entity;


/**
 * 历史记录
 */
public class Historyrecord {
    /** ID */
    private Integer id;
    /** 内容编号 */
    private Integer contentId;
    /** 板块编号 */
    private Integer plate;
    /** 用户编号 */
    private Integer userId;
    /** 浏览时间 */
    private String time;

    /** 话题编号 */
    private String topicId;
    /** 话题标题 */
    private String topicTitle;

    /** 话题编号 */
    private String activityId;
    /** 活动名称 */
    private String activityName;


    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    public Integer getPlate() {
        return plate;
    }

    public void setPlate(Integer plate) {
        this.plate = plate;
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