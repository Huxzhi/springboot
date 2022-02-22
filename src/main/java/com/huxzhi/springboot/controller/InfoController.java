package com.huxzhi.springboot.controller;

//导入需要的包

import cn.hutool.core.collection.CollUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huxzhi.springboot.common.Result;
import com.huxzhi.springboot.entity.Info;
import com.huxzhi.springboot.service.IInfoService;
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
 * @since 2022-02-21
 */
@RestController
@RequestMapping("/info")
public class InfoController {

    @Resource
    private IInfoService infoService;

    //新增或者更新
    @PostMapping
    public Result save(@RequestBody Info info) {
        return Result.success(infoService.saveOrUpdate(info));
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return Result.success(infoService.removeById(id));
    }

    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        return Result.success(infoService.removeByIds(ids));
    }

    //查询所有数据
    @GetMapping
    public Result findAll() {
        return Result.success(infoService.list());
    }


    @PostMapping("/update")
    public Result update(@RequestBody Info info) {
        return Result.success(infoService.updateById(info));
    }

    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        return Result.success(infoService.getById(id));
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                           @RequestParam Integer pageSize,
                           @RequestParam String infoname,
                           @RequestParam String idCard) {

        QueryWrapper<Info> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        if (!"".equals(infoname)) {
            queryWrapper.like("infoname", infoname);
        }
        if (!"".equals(idCard)) {
            queryWrapper.like("id_card", idCard);
        }

        return Result.success(infoService.page(new Page<>(pageNum, pageSize), queryWrapper));
    }

    /**
     * 导出接口
     */
    @GetMapping("/export")
    public void export(HttpServletResponse response) throws Exception {
        // 从数据库查询出所有的数据
        List<Info> list = infoService.list();
        // 通过工具类创建writer 写出到磁盘路径
//        ExcelWriter writer = ExcelUtil.getWriter(filesUploadPath + "/用户信息.xlsx");
        // 在内存操作，写出到浏览器
        ExcelWriter writer = ExcelUtil.getWriter(true);
        //自定义标题别名
        writer.addHeaderAlias("infoname", "真实姓名");
        writer.addHeaderAlias("age", "年龄");
        writer.addHeaderAlias("gender", "性别");
        writer.addHeaderAlias("nation", "民族");
        writer.addHeaderAlias("idCard", "身份证号");
        writer.addHeaderAlias("politicalOutlook", "政治面貌");
        writer.addHeaderAlias("marital", "婚姻状况");
        writer.addHeaderAlias("currentSidence", "现居地");
        writer.addHeaderAlias("phone", "电话号");
        writer.addHeaderAlias("isSeniorTechnician", "是否为高级技术人才");
        writer.addHeaderAlias("isDisability", "是否残疾");
        writer.addHeaderAlias("isSoldier", "是否军人");
        writer.addHeaderAlias("isForeigner", "是否外国人");

        // 一次性写出list内的对象到excel，使用默认样式，强制输出标题
        writer.write(list, true);

        // 设置浏览器响应的格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("流动人口信息表", "UTF-8");
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
//        List<User> list = reader.readAll(User.class);

        // 方式2：忽略表头的中文，直接读取表的内容
        List<List<Object>> list = reader.read(1);
        List<Info> infos = CollUtil.newArrayList();
        for (List<Object> row : list) {
            Info info = new Info();
            info.setInfoname(row.get(0).toString());
            info.setAge(Integer.parseInt(row.get(1).toString()));
            info.setGender(row.get(2).toString());
            info.setNation(row.get(3).toString());
            info.setIdCard(row.get(4).toString());
            info.setPoliticalOutlook(row.get(5).toString());
            info.setMarital(row.get(6).toString());
            info.setCurrentSidence(row.get(7).toString());
            info.setPhone(row.get(8).toString());
            info.setIsSeniorTechnician(Boolean.parseBoolean(row.get(9).toString()));
            info.setIsDisability(Boolean.parseBoolean(row.get(10).toString()));
            info.setIsSoldier(Boolean.parseBoolean(row.get(11).toString()));
            info.setIsForeigner(Boolean.parseBoolean(row.get(12).toString()));

            infos.add(info);
        }

        infoService.saveBatch(infos);
        return Result.success(true);
    }
}

