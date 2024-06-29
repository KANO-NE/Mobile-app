package com.example.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.example.common.enums.ResultCodeEnum;
import com.example.entity.Collect;
import com.example.entity.Usercollect;
import com.example.exception.CustomException;
import com.example.mapper.UsercollectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 用户关注业务处理
 **/
@Service
public class UsercollectService {

    @Resource
    private UsercollectMapper usercollectMapper;

    /**
     * 新增
     */
    public void add(Usercollect usercollect) {

        Usercollect dbusercollect = usercollectMapper.selectByUserIdAndTargetId(usercollect.getUserId(), usercollect.getTargetId());
        if (ObjectUtil.isNotEmpty(dbusercollect)) { //如果有值 已关注=》不让关注
            throw new CustomException(ResultCodeEnum.USERCOLLECT_ALREADY_ERROR);
        }
        usercollect.setTime(DateUtil.now()); //设置当前最新时间
        usercollectMapper.insert(usercollect);
    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        usercollectMapper.deleteById(id);
    }

    /**
     * 批量删除
     */
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            usercollectMapper.deleteById(id);
        }
    }

    /**
     * 修改
     */
    public void updateById(Usercollect usercollect) {
        usercollectMapper.updateById(usercollect);
    }

    /**
     * 根据ID查询
     */
    public Usercollect selectById(Integer id) {
        return usercollectMapper.selectById(id);
    }

    /**
     * 查询所有
     */
    public List<Usercollect> selectAll(Usercollect usercollect) {
        return usercollectMapper.selectAll(usercollect);
    }

    /**
     * 分页查询
     */
    public PageInfo<Usercollect> selectPage(Usercollect usercollect, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Usercollect> list = usercollectMapper.selectAll(usercollect);
        return PageInfo.of(list);
    }

    public List<Usercollect> selectByUserId(Integer id) {
        return usercollectMapper.selectByUserId(id);
    }
}