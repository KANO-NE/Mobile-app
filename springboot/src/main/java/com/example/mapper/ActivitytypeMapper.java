package com.example.mapper;

import com.example.entity.Activitytype;
import java.util.List;

/**
 * 操作activitytype相关数据接口
 */
public interface ActivitytypeMapper {

    /**
     * 新增
     */
    int insert(Activitytype activitytype);

    /**
     * 删除
     */
    int deleteById(Integer id);

    /**
     * 修改
     */
    int updateById(Activitytype activitytype);

    /**
     * 根据ID查询
     */
    Activitytype selectById(Integer id);

    /**
     * 查询所有
     */
    List<Activitytype> selectAll(Activitytype activitytype);

}