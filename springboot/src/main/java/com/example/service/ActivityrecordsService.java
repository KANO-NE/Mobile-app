package com.example.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.example.common.enums.ResultCodeEnum;
import com.example.entity.Activity;
import com.example.entity.Activityrecords;
import com.example.exception.CustomException;
import com.example.mapper.ActivityMapper;
import com.example.mapper.ActivityrecordsMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 活动记录业务处理
 **/
@Service
public class ActivityrecordsService {

    @Resource
    private ActivityrecordsMapper activityrecordsMapper;

    @Resource
    private ActivityMapper activityMapper;

    /**
     * 新增
     */
    public void add(Activityrecords activityrecords) {

        Activityrecords dbActivityrecords = activityrecordsMapper.selectByUserIdAndActivityId(activityrecords.getUserId(),activityrecords.getActivityId());
        if (ObjectUtil.isNotEmpty(dbActivityrecords)) { //如果有值 已加入  =》不让添加数据库
            throw new CustomException(ResultCodeEnum.ACTIVITY_EXIST_ERROR);
        }
        activityrecords.setTime(DateUtil.format(new Date(), "yyyy-MM-dd HH:mm"));
        activityrecordsMapper.insert(activityrecords);


        //活动人数+1
        Activity activity = activityMapper.selectById(activityrecords.getActivityId());
        activity.setNum(activity.getNum() + 1);
        activityMapper.updateById(activity);

    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        Activityrecords dbActivityrecords =  activityrecordsMapper.selectById(id);
        activityrecordsMapper.deleteById(id);

        //活动人数-1
        Activity activity = activityMapper.selectById(dbActivityrecords.getActivityId());
        activity.setNum(activity.getNum() - 1);
        activityMapper.updateById(activity);
    }

    /**
     * 批量删除
     */
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            activityrecordsMapper.deleteById(id);
        }
    }

    /**
     * 修改
     */
    public void updateById(Activityrecords activityrecords) {
        activityrecordsMapper.updateById(activityrecords);
    }

    /**
     * 根据ID查询
     */
    public Activityrecords selectById(Integer id) {
        return activityrecordsMapper.selectById(id);
    }

    /**
     * 查询所有
     */
    public List<Activityrecords> selectAll(Activityrecords activityrecords) {
        return activityrecordsMapper.selectAll(activityrecords);
    }

    /**
     * 分页查询
     */
    public PageInfo<Activityrecords> selectPage(Activityrecords activityrecords, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Activityrecords> list = activityrecordsMapper.selectAll(activityrecords);
        return PageInfo.of(list);
    }

    public List<Activityrecords> selectByActivityId(Integer id) {
        return activityrecordsMapper.selectByActivityId(id);
    }

    public List<Activityrecords> selectByUserId(Integer id) {
        return activityrecordsMapper.selectByUserId(id);
    }

    public void deleteByactivityId(Integer activityId) {
        activityrecordsMapper.deleteByactivityId(activityId);
    }
}