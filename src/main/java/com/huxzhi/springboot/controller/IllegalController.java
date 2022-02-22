package com.huxzhi.springboot.controller;

//导入需要的包

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huxzhi.springboot.common.Result;
import com.huxzhi.springboot.entity.Illegal;
import com.huxzhi.springboot.service.IIllegalService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author huxzhi
 * @since 2022-02-22
 */
@RestController
@RequestMapping("/illegal")
public class IllegalController {

    @Resource
    private IIllegalService illegalService;

    //新增或者更新
    @PostMapping
    public Result save(@RequestBody Illegal illegal) {
        return Result.success(illegalService.saveOrUpdate(illegal));
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return Result.success(illegalService.removeById(id));
    }

    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        return Result.success(illegalService.removeByIds(ids));
    }

    //查询所有数据
    @GetMapping
    public Result findAll() {
        return Result.success(illegalService.list());
    }

    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        return Result.success(illegalService.getById(id));
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                           @RequestParam Integer pageSize) {

        QueryWrapper<Illegal> queryWrapper = new QueryWrapper<>();

        //进行倒序输出
        queryWrapper.orderByDesc("id");
        return Result.success(illegalService.page(new Page<>(pageNum, pageSize), queryWrapper));
    }
}

