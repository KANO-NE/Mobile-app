package com.example.controller;

import com.example.common.Result;
import com.example.entity.Topicreply;
import com.example.service.TopicreplyService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * 话题回复信息前端操作接口
 **/
@RestController
@RequestMapping("/topicreply")
public class TopicreplyController {

    @Resource
    private TopicreplyService topicreplyService;

    /**
     * 新增
     */
    @PostMapping("/add")
    public Result add(@RequestBody Topicreply topicreply) {
        topicreplyService.add(topicreply);
        return Result.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        topicreplyService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        topicreplyService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public Result updateById(@RequestBody Topicreply topicreply) {
        topicreplyService.updateById(topicreply);
        return Result.success();
    }

    /**
     * 根据ID查询
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        Topicreply topicreply = topicreplyService.selectById(id);
        return Result.success(topicreply);
    }


    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    public Result selectAll(Topicreply topicreply) {
        List<Topicreply> list = topicreplyService.selectAll(topicreply);
        return Result.success(list);
    }

    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    public Result selectPage(Topicreply topicreply,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Topicreply> page = topicreplyService.selectPage(topicreply, pageNum, pageSize);
        return Result.success(page);
    }

    /**
     * 查询话题留言信息
     */
    @GetMapping("/selectByTopicId")
    public Result selectByTopicId(@RequestParam Integer id) {
        List<Topicreply> list = topicreplyService.selectByTopicId(id);
        return Result.success(list);
    }

}