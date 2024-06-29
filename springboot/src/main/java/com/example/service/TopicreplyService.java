package com.example.service;

import cn.hutool.core.date.DateUtil;
import com.example.entity.Activityrecords;
import com.example.entity.Topic;
import com.example.entity.Topicreply;
import com.example.mapper.TopicMapper;
import com.example.mapper.TopicreplyMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 话题回复信息业务处理
 **/
@Service
public class TopicreplyService {

    @Resource
    private TopicreplyMapper topicreplyMapper;
    @Resource
    private TopicMapper topicMapper;

    /**
     * 新增
     */
    public void add(Topicreply topicreply) {
        //创建
        topicreply.setTime(DateUtil.format(new Date(), "yyyy-MM-dd HH:mm"));
        topicreplyMapper.insert(topicreply);
        //添加留言次数
        Topic topic =  topicMapper.selectById(topicreply.getTopicId());
        topic.setNum(topic.getNum() +1);
        topic.setReply(topic.getReply() +1);
        topicMapper.updateById(topic);
    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        Topicreply topicreply =  topicreplyMapper.selectById(id);
        topicreplyMapper.deleteById(id);
        //留言次数-1
        Topic topic = topicMapper.selectById(topicreply.getTopicId());
        topic.setReply(topic.getReply() - 1);
        topicMapper.updateById(topic);
    }

    /**
     * 批量删除
     */
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            topicreplyMapper.deleteById(id);
        }
    }

    /**
     * 修改
     */
    public void updateById(Topicreply topicreply) {
        topicreplyMapper.updateById(topicreply);
    }

    /**
     * 根据ID查询
     */
    public Topicreply selectById(Integer id) {
        return topicreplyMapper.selectById(id);
    }

    /**
     * 查询所有
     */
    public List<Topicreply> selectAll(Topicreply topicreply) {
        return topicreplyMapper.selectAll(topicreply);
    }

    /**
     * 分页查询
     */
    public PageInfo<Topicreply> selectPage(Topicreply topicreply, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Topicreply> list = topicreplyMapper.selectAll(topicreply);
        return PageInfo.of(list);
    }


    public List<Topicreply> selectByTopicId(Integer id) {
        return topicreplyMapper.selectByTopicId(id);
    }
}