package com.huxzhi.springboot.controller;

import com.huxzhi.springboot.common.Result;
import com.huxzhi.springboot.service.MyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/my")
public class MyController {
    @Resource
    private MyService myService;

    @GetMapping
    public Result getData(@RequestParam Integer id) {
        return Result.success(myService.getData(id));
    }

}
