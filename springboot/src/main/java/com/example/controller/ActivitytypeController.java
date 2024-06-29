package com.example.controller;

import com.example.common.Result;
import com.example.entity.Activitytype;
import com.example.service.ActivitytypeService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * 活动类型前端操作接口
 **/
@RestController
@RequestMapping("/activitytype")
public class ActivitytypeController {

    @Resource
    private ActivitytypeService activitytypeService;

    /**
     * 新增
     */
    @PostMapping("/add")
    public Result add(@RequestBody Activitytype activitytype) {
        activitytypeService.add(activitytype);
        return Result.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        activitytypeService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        activitytypeService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public Result updateById(@RequestBody Activitytype activitytype) {
        activitytypeService.updateById(activitytype);
        return Result.success();
    }

    /**
     * 根据ID查询
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        Activitytype activitytype = activitytypeService.selectById(id);
        return Result.success(activitytype);
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    public Result selectAll(Activitytype activitytype) {
        List<Activitytype> list = activitytypeService.selectAll(activitytype);
        return Result.success(list);
    }

    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    public Result selectPage(Activitytype activitytype,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Activitytype> page = activitytypeService.selectPage(activitytype, pageNum, pageSize);
        return Result.success(page);
    }

}