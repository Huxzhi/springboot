package com.huxzhi.springboot.controller;

import com.huxzhi.springboot.bean.User;
import com.huxzhi.springboot.mapper.UserMapper;
import com.huxzhi.springboot.service.Ipml.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/user")
@RestController // 等价于@ResponseBody + @Controller。
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserServiceImpl userService;

    //查询所有数据
    @GetMapping
    public List<User> findAllUsers() {
        return userMapper.findAll();
    }

    @PostMapping
    public Boolean saveUser(@RequestBody User user) {
        //新增或者更新
        return userService.userSave(user);
    }

    @DeleteMapping("/{id}")
    public Integer deleteUser(@PathVariable Integer id) {
        return userMapper.deleteUserById(id);
    }


    //分页查询
    //接口路径：/user/page
    //@RequestParam 接受 ?pageNum=1&pageSize=10
    @GetMapping("/page")
    public Map<String, Object> findPageUsers(@RequestParam Integer pageNum,
                                             @RequestParam Integer pageSize,
                                             @RequestParam String username) {
        pageNum = (pageNum - 1) * pageSize;

        List<User> dataUser = userMapper.selectPageUsers(pageNum, pageSize, username);
        Integer totalUser = userMapper.selectTotalUser(username);

        Map<String, Object> res = new HashMap<>();
        res.put("data", dataUser);
        res.put("total", totalUser);

        return res;
    }


//    @PutMapping
//    public String putUser() {
//        return "PUT-张三";
//    }
}
