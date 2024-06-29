package com.example.service;

import cn.hutool.core.date.DateUtil;
import com.example.entity.Topic;
import com.example.mapper.TopicMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 今日话题业务处理
 **/
@Service
public class TopicService {

    @Resource
    private TopicMapper topicMapper;

    /**
     * 新增
     */
    public void add(Topic topic) {
        topic.setTime(DateUtil.now()); //设置当前最新时间
        topicMapper.insert(topic);
    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        topicMapper.deleteById(id);
    }

    /**
     * 批量删除
     */
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            topicMapper.deleteById(id);
        }
    }

    /**
     * 修改
     */
    public void updateById(Topic topic) {
        topicMapper.updateById(topic);
    }

    /**
     * 根据ID查询
     */
    public Topic selectById(Integer id) {
        return topicMapper.selectById(id);
    }

    /**
     * 查询所有
     */
    public List<Topic> selectAll(Topic topic) {
        return topicMapper.selectAll(topic);
    }

    /**
     * 分页查询
     */
    public PageInfo<Topic> selectPage(Topic topic, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Topic> list = topicMapper.selectAll(topic);
        return PageInfo.of(list);
    }

    /**
     * 查询最火的两个话题
     * @return
     */
    public List<Topic> selectHot() {
        return topicMapper.selectHot();
    }

    public List<Topic> selectByUserName(String name) {
        return topicMapper.selectByUserName(name);
    }
}