package com.example.service;

import cn.hutool.core.date.DateUtil;
import com.example.entity.Historyrecord;
import com.example.mapper.HistoryrecordMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 历史记录业务处理
 **/
@Service
public class HistoryrecordService {

    @Resource
    private HistoryrecordMapper historyrecordMapper;

    /**
     * 新增
     */
    public void add(Historyrecord historyrecord) {
        historyrecord.setTime(DateUtil.now()); //设置当前最新时间
        historyrecordMapper.insert(historyrecord);
    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        historyrecordMapper.deleteById(id);
    }

    /**
     * 批量删除
     */
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            historyrecordMapper.deleteById(id);
        }
    }

    /**
     * 修改
     */
    public void updateById(Historyrecord historyrecord) {
        historyrecordMapper.updateById(historyrecord);
    }

    /**
     * 根据ID查询
     */
    public Historyrecord selectById(Integer id) {
        return historyrecordMapper.selectById(id);
    }

    /**
     * 查询所有
     */
    public List<Historyrecord> selectAll(Historyrecord historyrecord) {
        return historyrecordMapper.selectAll(historyrecord);
    }

    /**
     * 分页查询
     */
    public PageInfo<Historyrecord> selectPage(Historyrecord historyrecord, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Historyrecord> list = historyrecordMapper.selectAll(historyrecord);
        return PageInfo.of(list);
    }

    public List<Historyrecord> selectUserTopic(Historyrecord historyrecord) {
        return historyrecordMapper.selectUserTopic(historyrecord);
    }

    public List<Historyrecord> selectUserActivity(Historyrecord historyrecord) {
        return historyrecordMapper.selectUserActivity(historyrecord);
    }
}