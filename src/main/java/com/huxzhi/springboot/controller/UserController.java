package com.huxzhi.springboot.controller;

import com.huxzhi.springboot.bean.User;
import com.huxzhi.springboot.mapper.UserMapper;
import com.huxzhi.springboot.service.Ipml.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@RestController // 等价于@ResponseBody + @Controller。
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserServiceImpl userService;


    //查询所有数据
    @GetMapping
    public List<User> users() {
        return userMapper.findAll();
    }

    @PostMapping
    public Integer saveUser(@RequestBody User user) {
        //新增或者更新
        return userService.userSave(user);
    }

    @DeleteMapping("/{id}")
    public Integer deleteUser(@PathVariable Integer id) {
        return userMapper.deleteUserById(id);
    }

    @PutMapping
    public String putUser() {
        return "PUT-张三";
    }
}
