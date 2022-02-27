package com.huxzhi.springboot.controller;

import com.huxzhi.springboot.common.Result;
import com.huxzhi.springboot.mapper.BindMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static com.huxzhi.springboot.common.Constants.CODE_600;

@RestController
@RequestMapping("/bind")
public class BindController {
    @Resource
    BindMapper bindMapper;

    @GetMapping("/saveinfo")
    public Result saveInfo(@RequestParam Integer userId,
                           @RequestParam Integer infoId) {

        if (bindMapper.saveInfo(userId, infoId) < 1) {
            return Result.error(CODE_600, "一个角色只能绑定一个人口信息，请先解除绑定");
        }
        return Result.success();
    }


}
