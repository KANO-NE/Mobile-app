package com.example.mapper;

import com.example.entity.Account;
import com.example.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 操作user相关数据接口
 */
public interface UserMapper {

    /**
     * 新增
     */
    int insert(User user);

    /**
     * 删除
     */
    int deleteById(Integer id);

    /**
     * 修改
     */
    int updateById(User user);

    /**
     * 根据ID查询
     */
    User selectById(Integer id);

    /**
     * 查询所有
     */
    List<User> selectAll(User user);

    /**
     * 判断是否存在该用户
     * @param username
     * @return
     */
    @Select("select * from user where username = #{username}")
    User selectByUsername(String username);

    /**
     * 查询搜索内容
     * @param user
     * @return
     */
    @Select("select * from user where username = #{name}")
    List<User> selectByName(User user);
}