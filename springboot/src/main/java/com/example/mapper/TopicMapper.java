package com.example.mapper;

import com.example.entity.Topic;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 操作topic相关数据接口
 */
public interface TopicMapper {

    /**
     * 新增
     */
    int insert(Topic topic);

    /**
     * 删除
     */
    int deleteById(Integer id);

    /**
     * 修改
     */
    int updateById(Topic topic);

    /**
     * 根据ID查询
     */
    Topic selectById(Integer id);

    /**
     * 查询所有
     */
    List<Topic> selectAll(Topic topic);


    List<Topic> selectHot();

    /**
     * 根据用户名称该用户创建的话题长度
     * @return
     */
    @Select("select * from topic where name = #{name}")
    List<Topic> selectByUserName(String name);
}