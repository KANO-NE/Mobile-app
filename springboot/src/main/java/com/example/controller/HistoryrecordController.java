package com.example.controller;

import com.example.common.Result;
import com.example.entity.Historyrecord;
import com.example.service.HistoryrecordService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * 历史记录前端操作接口
 **/
@RestController
@RequestMapping("/historyrecord")
public class HistoryrecordController {

    @Resource
    private HistoryrecordService historyrecordService;

    /**
     * 新增
     */
    @PostMapping("/add")
    public Result add(@RequestBody Historyrecord historyrecord) {
        historyrecordService.add(historyrecord);
        return Result.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        historyrecordService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        historyrecordService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public Result updateById(@RequestBody Historyrecord historyrecord) {
        historyrecordService.updateById(historyrecord);
        return Result.success();
    }

    /**
     * 根据ID查询
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        Historyrecord historyrecord = historyrecordService.selectById(id);
        return Result.success(historyrecord);
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    public Result selectAll(Historyrecord historyrecord) {
        List<Historyrecord> list = historyrecordService.selectAll(historyrecord);
        return Result.success(list);
    }

    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    public Result selectPage(Historyrecord historyrecord,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Historyrecord> page = historyrecordService.selectPage(historyrecord, pageNum, pageSize);
        return Result.success(page);
    }

    /**
     * 查询用户话题
     */
    @GetMapping("/selectUserTopic")
    public Result selectUserTopic(Historyrecord historyrecord) {
        List<Historyrecord> list = historyrecordService.selectUserTopic(historyrecord);
        return Result.success(list);
    }

    /**
     * 查询用户活动
     */
    @GetMapping("/selectUserActivity")
    public Result selectUserActivity(Historyrecord historyrecord) {
        List<Historyrecord> list = historyrecordService.selectUserActivity(historyrecord);
        return Result.success(list);
    }
}