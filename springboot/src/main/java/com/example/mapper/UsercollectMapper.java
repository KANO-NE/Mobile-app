package com.example.mapper;

import com.example.entity.Collect;
import com.example.entity.Usercollect;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 操作usercollect相关数据接口
 */
public interface UsercollectMapper {

    /**
     * 新增
     */
    int insert(Usercollect usercollect);

    /**
     * 删除
     */
    int deleteById(Integer id);

    /**
     * 修改
     */
    int updateById(Usercollect usercollect);

    /**
     * 根据ID查询
     */
    Usercollect selectById(Integer id);

    /**
     * 查询所有
     */
    List<Usercollect> selectAll(Usercollect usercollect);

    /**
     * 判断是否关注
     */
    @Select("select * from usercollect where user_id = #{userId} and target_id = #{targetId}")
    Usercollect selectByUserIdAndTargetId(@Param("userId")Integer userId,@Param("targetId") Integer targetId);

    /**
     * 获取关注的用户
     * @param id
     * @return
     */
    List<Usercollect> selectByUserId(Integer id);
}