package com.example.mapper;

import com.example.entity.Collect;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 操作collect相关数据接口
 */
public interface CollectMapper {

    /**
     * 新增
     */
    int insert(Collect collect);

    /**
     * 删除
     */
    int deleteById(Integer id);

    /**
     * 修改
     */
    int updateById(Collect collect);

    /**
     * 根据ID查询
     */
    Collect selectById(Integer id);

    /**
     * 查询所有
     */
    List<Collect> selectAll(Collect collect);

    /**
     * 判断是否收藏
     */
    @Select("select * from collect where user_id = #{userId} and topic_id = #{topicId}")
    Collect selectByUserIdAndTopicId(@Param("userId") Integer userId,@Param("topicId")  Integer topicId);
    /**
     * 根据用户编号查询已收藏的话题
     */
    List<Collect> selectByUserId(Integer id);
}