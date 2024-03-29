package com.huxzhi.springboot.controller;

//导入需要的包

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huxzhi.springboot.common.Result;
import com.huxzhi.springboot.entity.Illegal;
import com.huxzhi.springboot.mapper.IllegalMapper;
import com.huxzhi.springboot.mapper.MyMapper;
import com.huxzhi.springboot.service.IIllegalService;
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
@RequestMapping("/illegal")
public class IllegalController {

    @Resource
    private IIllegalService illegalService;
    @Resource
    private MyMapper myMapper;
    @Resource
    private IllegalMapper illegalMapper;

    //补充，新增未处理的已处理的违法记录
    @GetMapping("/handle/{id}")
    public Result findHandleOne(@PathVariable Integer id) {
        return Result.success(illegalService.getById(id));
    }

    @GetMapping("/mishandle/{id}")
    public Result findMishandleOne(@PathVariable Integer id) {
        return Result.success(myMapper.getUserIllegal(id));
    }

    @PostMapping("/accept")
    public Result accept(@RequestBody Integer id) {

        UpdateWrapper<Illegal> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", id).set("is_accepted", 1);
        illegalMapper.update(null, updateWrapper);
        return Result.success();
    }


    //新增或者更新
    @PostMapping
    public Result save(@RequestBody Illegal illegal) {
        return Result.success(illegalService.saveOrUpdate(illegal));
    }

    @PostMapping("/update")
    public Result update(@RequestBody Illegal illegal) {
        return Result.success(illegalService.updateById(illegal));
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
                           @RequestParam Integer pageSize,
                           @RequestParam(defaultValue = "") String illegalPlace,
                           @RequestParam(defaultValue = "") String illegalActivities,
                           @RequestParam(defaultValue = "") String illegalPerson
    ) {

        QueryWrapper<Illegal> queryWrapper = new QueryWrapper<>();
        if (!"".equals(illegalPlace)) {
            queryWrapper.like("illegal_place", illegalPlace);
        }
        if (!"".equals(illegalActivities)) {
            queryWrapper.like("illegal_activities", illegalActivities);
        }
        if (!"".equals(illegalPerson)) {
            queryWrapper.like("illegal_person", illegalPerson);
        }
        //进行倒序输出
        queryWrapper.orderByDesc("id");
        return Result.success(illegalService.page(new Page<>(pageNum, pageSize), queryWrapper));
    }

    /**
     * 导出接口
     */
    @GetMapping("/export")
    public void export(HttpServletResponse response) throws Exception {
        // 从数据库查询出所有的数据
        List<Illegal> list = illegalService.list();
        // 在内存操作，写出到浏览器
        ExcelWriter writer = ExcelUtil.getWriter(true);

        // 一次性写出list内的对象到excel，使用默认样式，强制输出标题
        writer.write(list, true);

        // 设置浏览器响应的格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("违法记录信息表", "UTF-8");
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
        List<Illegal> list = reader.readAll(Illegal.class);

        illegalService.saveOrUpdateBatch(list);
        return Result.success(true);
    }
}

