package com.huxzhi.springboot.controller;

import com.huxzhi.springboot.common.Result;
import com.huxzhi.springboot.controller.dto.PostResidenceDTO;
import com.huxzhi.springboot.service.MyService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("postresidence")
    public Result postResidence(@RequestBody PostResidenceDTO postResidenceDTO) {
        myService.postResidence(postResidenceDTO);
        return Result.success();
    }

}
