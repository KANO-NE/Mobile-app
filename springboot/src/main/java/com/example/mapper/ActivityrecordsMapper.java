package com.example.mapper;

import com.example.entity.Activityrecords;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 操作activityrecords相关数据接口
 */
public interface ActivityrecordsMapper {

    /**
     * 新增
     */
    int insert(Activityrecords activityrecords);

    /**
     * 删除
     */
    int deleteById(Integer id);

    /**
     * 修改
     */
    int updateById(Activityrecords activityrecords);

    /**
     * 根据ID查询
     */
    Activityrecords selectById(Integer id);

    /**
     * 查询所有
     */
    List<Activityrecords> selectAll(Activityrecords activityrecords);

    /**
     * 查询是否用户已加入该活动
     */
    @Select("select * from activityrecords where user_id = #{userId} and activity_id = #{activityId}")
    Activityrecords selectByUserIdAndActivityId(Integer userId, Integer activityId);

    /**
     * 根据活动编号查询加入用户
     */
    //@Select("select * from activityrecords where activity_id = #{id}")
    List<Activityrecords> selectByActivityId(Integer id);

    /**
     * 根据用户编号查询已加入的活动
     */
    //@Select("select * from activityrecords where user_id = #{id}")
    List<Activityrecords> selectByUserId(Integer id);

    /**
     * 删除活动时删除存在记录
     */
    @Delete("DELETE FROM activityrecords where activity_id = #{activityId}")
    void deleteByactivityId(Integer activityId);
}