package com.example.controller;

import com.example.common.Result;
import com.example.entity.Collect;
import com.example.entity.Usercollect;
import com.example.service.UsercollectService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * 用户关注前端操作接口
 **/
@RestController
@RequestMapping("/usercollect")
public class UsercollectController {

    @Resource
    private UsercollectService usercollectService;

    /**
     * 新增
     */
    @PostMapping("/add")
    public Result add(@RequestBody Usercollect usercollect) {
        usercollectService.add(usercollect);
        return Result.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        usercollectService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        usercollectService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public Result updateById(@RequestBody Usercollect usercollect) {
        usercollectService.updateById(usercollect);
        return Result.success();
    }

    /**
     * 根据ID查询
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        Usercollect usercollect = usercollectService.selectById(id);
        return Result.success(usercollect);
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    public Result selectAll(Usercollect usercollect) {
        List<Usercollect> list = usercollectService.selectAll(usercollect);
        return Result.success(list);
    }

    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    public Result selectPage(Usercollect usercollect,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Usercollect> page = usercollectService.selectPage(usercollect, pageNum, pageSize);
        return Result.success(page);
    }

    /**
     * 根据用户编号获取收藏信息
     */
    @GetMapping("/selectByUserId")
    public Result selectByUserId(@RequestParam Integer id){
        List<Usercollect> list = usercollectService.selectByUserId(id);
        return Result.success(list);
    }

}