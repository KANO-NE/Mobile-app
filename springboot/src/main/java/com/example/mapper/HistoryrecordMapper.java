package com.example.mapper;

import com.example.entity.Historyrecord;
import java.util.List;

/**
 * 操作historyrecord相关数据接口
 */
public interface HistoryrecordMapper {

    /**
     * 新增
     */
    int insert(Historyrecord historyrecord);

    /**
     * 删除
     */
    int deleteById(Integer id);

    /**
     * 修改
     */
    int updateById(Historyrecord historyrecord);

    /**
     * 根据ID查询
     */
    Historyrecord selectById(Integer id);

    /**
     * 查询所有
     */
    List<Historyrecord> selectAll(Historyrecord historyrecord);

    List<Historyrecord> selectUserTopic(Historyrecord historyrecord);

    List<Historyrecord> selectUserActivity(Historyrecord historyrecord);
}