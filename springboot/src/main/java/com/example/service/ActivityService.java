package com.example.service;

import cn.hutool.core.date.DateUtil;
import com.example.entity.Account;
import com.example.entity.Activity;
import com.example.entity.Activityrecords;
import com.example.mapper.ActivityMapper;
import com.example.mapper.ActivityrecordsMapper;
import com.example.utils.TokenUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 活动业务处理
 **/
@Service
public class ActivityService {

    @Resource
    private ActivityMapper activityMapper;
    //引用加入活动的映射
    @Resource
    private ActivityrecordsMapper activityrecordsMapper;
    @Resource
    private ActivityrecordsService activityrecordsService;

    /**
     * 新增
     */
    public void add(Activity activity) {

        activity.setTime(DateUtil.format(new Date(), "yyyy-MM-dd HH:mm"));
        Activityrecords activityrecords = new Activityrecords();
        activityMapper.insert(activity);

        activityrecords.setUserId(activity.getUserId()); //设置当前用户的编号
        activityrecords.setActivityId(activity.getId()); //设置当前活动的编号
        activityrecords.setTime(DateUtil.format(new Date(), "yyyy-MM-dd HH:mm"));
        activityrecordsService.add(activityrecords);
    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        activityMapper.deleteById(id);
        activityrecordsService.deleteByactivityId(id);
    }

    /**
     * 批量删除
     */
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            activityMapper.deleteById(id);
        }
    }

    /**
     * 修改
     */
    public void updateById(Activity activity) {
        activityMapper.updateById(activity);
    }

    /**
     * 根据ID查询
     */
    public Activity selectById(Integer id) {
        return activityMapper.selectById(id);
    }

    /**
     * 查询所有
     */
    public List<Activity> selectAll(Activity activity) {
        return activityMapper.selectAll(activity);
    }

    /**
     * 分页查询
     */
    public PageInfo<Activity> selectPage(Activity activity, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Activity> list = activityMapper.selectAll(activity);
        return PageInfo.of(list);
    }

    public List<Activity> selectHot() {
        return activityMapper.selectHot();
    }

    public List<Activity> selectByName(Activity activity) {
        return activityMapper.selectByName(activity);
    }
}