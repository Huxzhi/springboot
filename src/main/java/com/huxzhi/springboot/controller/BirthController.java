package com.huxzhi.springboot.controller;

//导入需要的包

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huxzhi.springboot.common.Result;
import com.huxzhi.springboot.entity.Birth;
import com.huxzhi.springboot.service.IBirthService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.net.URLEncoder;
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
@RequestMapping("/birth")
public class BirthController {

    @Resource
    private IBirthService birthService;

    //新增或者更新
    @PostMapping
    public Result save(@RequestBody Birth birth) {
        return Result.success(birthService.saveOrUpdate(birth));
    }

    @PostMapping("/update")
    public Result update(@RequestBody Birth birth) {
        return Result.success(birthService.updateById(birth));
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return Result.success(birthService.removeById(id));
    }

    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        return Result.success(birthService.removeByIds(ids));
    }

    //查询所有数据
    @GetMapping
    public Result findAll() {
        return Result.success(birthService.list());
    }

    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        return Result.success(birthService.getById(id));
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                           @RequestParam Integer pageSize,
                           @RequestParam(defaultValue = "") String name,
                           @RequestParam(defaultValue = "") String idCard,
                           @RequestParam(defaultValue = "") String school) {

        QueryWrapper<Birth> queryWrapper = new QueryWrapper<>();
        if (!"".equals(name)) {
            queryWrapper.like("name", name);
        }
        if (!"".equals(idCard)) {
            queryWrapper.like("id_card", idCard);
        }
        if (!"".equals(school)) {
            queryWrapper.like("school", school);
        }
        //进行倒序输出
        queryWrapper.orderByDesc("id");
        return Result.success(birthService.page(new Page<>(pageNum, pageSize), queryWrapper));
    }

    /**
     * 导出接口
     */
    @GetMapping("/export")
    public void export(HttpServletResponse response) throws Exception {
        // 从数据库查询出所有的数据
        List<Birth> list = birthService.list();
        // 在内存操作，写出到浏览器
        ExcelWriter writer = ExcelUtil.getWriter(true);
        // 一次性写出list内的对象到excel，使用默认样式，强制输出标题
        writer.write(list, true);
        // 设置浏览器响应的格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("生育记录信息表", "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");
        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        out.close();
        writer.close();
    }

    /**
     * excel 导入
     *
     * @param file
     * @throws Exception
     */
    @PostMapping("/import")
    public Result imp(MultipartFile file) throws Exception {
        InputStream inputStream = file.getInputStream();
        ExcelReader reader = ExcelUtil.getReader(inputStream);
        // 方式1：(推荐) 通过 javabean的方式读取Excel内的对象，但是要求表头必须是英文，跟javabean的属性要对应起来
        List<Birth> list = reader.readAll(Birth.class);
        birthService.saveOrUpdateBatch(list);
        return Result.success(true);
    }

}

