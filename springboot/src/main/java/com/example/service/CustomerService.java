package com.example.service;

import cn.hutool.core.date.DateUtil;
import com.example.entity.Customer;
import com.example.mapper.CustomerMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 客服聊天业务处理
 **/
@Service
public class CustomerService {

    @Resource
    private CustomerMapper customerMapper;

    /**
     * 新增
     */
    public void add(Customer customer) {

        customer.setTime(DateUtil.format(new Date(), "yyyy-MM-dd HH:mm"));
        customerMapper.insert(customer);
    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        customerMapper.deleteById(id);
    }

    /**
     * 批量删除
     */
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            customerMapper.deleteById(id);
        }
    }

    /**
     * 修改
     */
    public void updateById(Customer customer) {
        customerMapper.updateById(customer);
    }

    /**
     * 根据ID查询
     */
    public Customer selectById(Integer id) {
        return customerMapper.selectById(id);
    }

    /**
     * 查询所有
     */
    public List<Customer> selectAll(Customer customer) {
        return customerMapper.selectAll(customer);
    }

    /**
     * 分页查询
     */
    public PageInfo<Customer> selectPage(Customer customer, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Customer> list = customerMapper.selectAll(customer);
        return PageInfo.of(list);
    }

    public List<Customer> selectByUserId(Integer id) {
        return customerMapper.selectByUserId(id);
    }
}