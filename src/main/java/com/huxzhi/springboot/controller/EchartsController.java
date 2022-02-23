package com.huxzhi.springboot.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.Quarter;
import com.huxzhi.springboot.common.Result;
import com.huxzhi.springboot.entity.Illegal;
import com.huxzhi.springboot.service.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/echarts")
public class EchartsController {

    @Resource
    private IUserService userService;
    @Resource
    private IInfoService infoService;
    @Resource
    private IResidenceService residenceService;
    @Resource
    private IIllegalService illegalService;
    @Resource
    private IBirthService birthService;


    @GetMapping("/total")
    public Result total() {
        Map<String, String> map = new HashMap<>();
        map.put("infoCount", infoService.count() + "");
        map.put("residenceCount", residenceService.count() + "");
        map.put("illegalCount", illegalService.count() + "");
        map.put("birthCount", birthService.count() + "");
        return Result.success(map);
    }


    @GetMapping("/illegalRecord")
    public Result get() {
        List<Illegal> list = illegalService.list();
        int q1 = 0; // 第一季度
        int q2 = 0; // 第二季度
        int q3 = 0; // 第三季度
        int q4 = 0; // 第四季度
        for (Illegal illegal : list) {
            Date createTime = illegal.getPenaltyTime();
            Quarter quarter = DateUtil.quarterEnum(createTime);
            switch (quarter) {
                case Q1:
                    q1 += 1;
                    break;
                case Q2:
                    q2 += 1;
                    break;
                case Q3:
                    q3 += 1;
                    break;
                case Q4:
                    q4 += 1;
                    break;
                default:
                    break;
            }
        }
        return Result.success(CollUtil.newArrayList(q1, q2, q3, q4));
    }

    @GetMapping("/age_range")
    public Result ageRange() {

        List<Integer> list = infoService.selectAge();
        int q1 = birthService.selectUnderage();   // 青少年 0-17
        int q2 = 0; // 劳动力人口 18-44
        int q3 = 0; // 45-59
        int q4 = 0; // 60及以上
        for (Integer i : list) {
            if (i < 45) {
                q2 += 1;
                continue;
            }
            if (i < 60) {
                q3 += 1;
                continue;
            }
            q4 += 1;
        }

        return Result.success(CollUtil.newArrayList(q1, q2, q3, q4));
    }

}
