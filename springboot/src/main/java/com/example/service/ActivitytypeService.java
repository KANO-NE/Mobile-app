package com.example.service;

import com.example.entity.Activitytype;
import com.example.mapper.ActivitytypeMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 活动类型业务处理
 **/
@Service
public class ActivitytypeService {

    @Resource
    private ActivitytypeMapper activitytypeMapper;

    /**
     * 新增
     */
    public void add(Activitytype activitytype) {
        activitytypeMapper.insert(activitytype);
    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        activitytypeMapper.deleteById(id);
    }

    /**
     * 批量删除
     */
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            activitytypeMapper.deleteById(id);
        }
    }

    /**
     * 修改
     */
    public void updateById(Activitytype activitytype) {
        activitytypeMapper.updateById(activitytype);
    }

    /**
     * 根据ID查询
     */
    public Activitytype selectById(Integer id) {
        return activitytypeMapper.selectById(id);
    }

    /**
     * 查询所有
     */
    public List<Activitytype> selectAll(Activitytype activitytype) {
        return activitytypeMapper.selectAll(activitytype);
    }

    /**
     * 分页查询
     */
    public PageInfo<Activitytype> selectPage(Activitytype activitytype, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Activitytype> list = activitytypeMapper.selectAll(activitytype);
        return PageInfo.of(list);
    }

}