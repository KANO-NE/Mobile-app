package com.example.controller;

import com.example.common.Result;
import com.example.entity.Activityrecords;
import com.example.entity.Topic;
import com.example.service.TopicService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * 今日话题前端操作接口
 **/
@RestController
@RequestMapping("/topic")
public class TopicController {

    @Resource
    private TopicService topicService;

    /**
     * 新增
     */
    @PostMapping("/add")
    public Result add(@RequestBody Topic topic) {
        topicService.add(topic);
        return Result.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        topicService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        topicService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public Result updateById(@RequestBody Topic topic) {
        topicService.updateById(topic);
        return Result.success();
    }

    /**
     * 根据ID查询
     */
    @GetMapping("/selectById1/{id}")
    public Result selectById1(@PathVariable Integer id) {
        Topic topic = topicService.selectById(id);
        return Result.success(topic);
    }

    @GetMapping("/selectById")
    public Result selectById(@RequestParam Integer id){
        Topic topic = topicService.selectById(id);
        return Result.success(topic);
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    public Result selectAll(Topic topic) {
        List<Topic> list = topicService.selectAll(topic);
        return Result.success(list);
    }

    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    public Result selectPage(Topic topic,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Topic> page = topicService.selectPage(topic, pageNum, pageSize);
        return Result.success(page);
    }

    /**
     * 用于获取最热门话题
     */
    @GetMapping("/selectHot")
    public Result selectHot9() {
        List<Topic> list = topicService.selectHot();
        return Result.success(list);
    }

    /**
     * 根据用户名称获取话题长度 =>个人页面展示
     */
    @GetMapping("/selectByUserName")
    public Result selectByUserName(@RequestParam String name){
        List<Topic> list = topicService.selectByUserName(name);
        return Result.success(list);
    }

}