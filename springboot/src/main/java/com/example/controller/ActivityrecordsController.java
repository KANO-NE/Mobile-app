package com.example.controller;

import com.example.common.Result;
import com.example.entity.Activityrecords;
import com.example.service.ActivityrecordsService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * 活动记录前端操作接口
 **/
@RestController
@RequestMapping("/activityrecords")
public class ActivityrecordsController {

    @Resource
    private ActivityrecordsService activityrecordsService;

    /**
     * 新增
     */
    @PostMapping("/add")
    public Result add(@RequestBody Activityrecords activityrecords) {
        activityrecordsService.add(activityrecords);
        return Result.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        activityrecordsService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        activityrecordsService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public Result updateById(@RequestBody Activityrecords activityrecords) {
        activityrecordsService.updateById(activityrecords);
        return Result.success();
    }

    /**
     * 根据ID查询
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        Activityrecords activityrecords = activityrecordsService.selectById(id);
        return Result.success(activityrecords);
    }



    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    public Result selectAll(Activityrecords activityrecords) {
        List<Activityrecords> list = activityrecordsService.selectAll(activityrecords);
        return Result.success(list);
    }

    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    public Result selectPage(Activityrecords activityrecords,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Activityrecords> page = activityrecordsService.selectPage(activityrecords, pageNum, pageSize);
        return Result.success(page);
    }

    /**
     * 根据活动编号获取信息
     */
    @GetMapping("/selectByActivityId")
    public Result selectByActivityId(@RequestParam Integer id){
        List<Activityrecords> list = activityrecordsService.selectByActivityId(id);
        return Result.success(list);
    }

    /**
     * 根据用户编号获取活动信息
     */
    @GetMapping("/selectByUserId")
    public Result selectByUserId(@RequestParam Integer id){
        List<Activityrecords> list = activityrecordsService.selectByUserId(id);
        return Result.success(list);
    }

}