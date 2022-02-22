package com.huxzhi.springboot.controller;

//导入需要的包

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
    public boolean save(@RequestBody Illegal illegal) {
        return illegalService.saveOrUpdate(illegal);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return illegalService.removeById(id);
    }

    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return illegalService.removeByIds(ids);
    }

    //查询所有数据
    @GetMapping
    public List<Illegal> findAll() {
        return illegalService.list();
    }

    @GetMapping("/{id}")
    public Illegal findOne(@PathVariable Integer id) {
        return illegalService.getById(id);
    }

    @GetMapping("/page")
    public Page<Illegal> findPage(@RequestParam Integer pageNum,
                                  @RequestParam Integer pageSize) {

        QueryWrapper<Illegal> queryWrapper = new QueryWrapper<>();

        //进行倒序输出
        queryWrapper.orderByDesc("id");
        return illegalService.page(new Page<>(pageNum, pageSize), queryWrapper);
    }
}

