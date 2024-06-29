package com.example.mapper;

import com.example.entity.Topicreply;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 操作topicreply相关数据接口
 */
public interface TopicreplyMapper {

    /**
     * 新增
     */
    int insert(Topicreply topicreply);

    /**
     * 删除
     */
    int deleteById(Integer id);

    /**
     * 修改
     */
    int updateById(Topicreply topicreply);

    /**
     * 根据ID查询
     */
    Topicreply selectById(Integer id);

    /**
     * 查询所有
     */
    List<Topicreply> selectAll(Topicreply topicreply);

    /**
     * 查询话题留言信息
     */
    //@Select("select * from topicreply where topic_id =  #{topicId} order by id desc")
    List<Topicreply> selectByTopicId(Integer id);




}