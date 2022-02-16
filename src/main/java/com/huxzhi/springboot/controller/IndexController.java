package com.huxzhi.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 等价于@ResponseBody + @Controller。
public class IndexController {
    @GetMapping("/")
    public String index(){
        return "ok";
    }
}
