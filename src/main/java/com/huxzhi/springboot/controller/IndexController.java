package com.huxzhi.springboot.controller;

import com.huxzhi.springboot.bean.User;
import com.huxzhi.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // 等价于@ResponseBody + @Controller。
public class IndexController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    public List<User> index(){
        return userMapper.findAll();
    }
}
