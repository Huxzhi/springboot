package com.huxzhi.springboot.service.Ipml;

import com.huxzhi.springboot.bean.User;
import com.huxzhi.springboot.mapper.UserMapper;
import com.huxzhi.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    //业务实现，
    public int userSave(User user) {
        if (user.getId() == null) {
            return userMapper.insert(user);
        } else {
            return userMapper.update(user);
        }
    }
}
