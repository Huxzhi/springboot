package com.huxzhi.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huxzhi.springboot.bean.User;
import com.huxzhi.springboot.service.Ipml.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@RestController // 等价于@ResponseBody + @Controller。
public class UserController {

//    @Autowired
//    private UserMapper userMapper;

    @Autowired
    private UserServiceImpl userService;

    //查询所有数据
    @GetMapping
    public List<User> findAllUsers() {
        return userService.list();
    }

    @PostMapping
    public Boolean saveUser(@RequestBody User user) {
        //新增或者更新
        return userService.userSave(user);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable Integer id) {
        return userService.removeById(id);
    }


    //分页查询
    //接口路径：/user/page
    //@RequestParam 接受 ?pageNum=1&pageSize=10
//    @GetMapping("/page")
//    public Map<String, Object> findPageUsers(@RequestParam Integer pageNum,
//                                             @RequestParam Integer pageSize,
//                                             @RequestParam String username) {
//        pageNum = (pageNum - 1) * pageSize;
//
//        List<User> dataUser = userMapper.selectPageUsers(pageNum, pageSize, username);
//        Integer totalUser = userMapper.selectTotalUser(username);
//
//        Map<String, Object> res = new HashMap<>();
//        res.put("data", dataUser);
//        res.put("total", totalUser);
//
//        return res;
//    }

    //分页查询 - mybatis-plus的方式
    @GetMapping("/page")
    public IPage<User> findPageUsers(@RequestParam Integer pageNum,
                                     @RequestParam Integer pageSize,
                                     @RequestParam(defaultValue = "") String username,
                                     @RequestParam(defaultValue = "") String nickname,
                                     @RequestParam(defaultValue = "") String address) {
        IPage<User> page = new Page<>(pageNum, pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        // queryWrapper.or().like("address", address); //错误的写法，会导致前面的条件全部失效

        if (!"".equals(username)) {
            queryWrapper.like("username", username);
        }
        if (!"".equals(nickname)) {
            queryWrapper.like("nickname", nickname);
        }
        if (!"".equals(address)) {
            queryWrapper.like("address", address);
        }


        return userService.page(page, queryWrapper);

    }

//    @PutMapping
//    public String putUser() {
//        return "PUT-张三";
//    }
}
