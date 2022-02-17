package com.huxzhi.springboot.service.Ipml;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huxzhi.springboot.bean.User;
import com.huxzhi.springboot.mapper.UserMapper;
import com.huxzhi.springboot.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    public boolean userSave(User user) {
//        if (user.getId() == null) {
//            return save(user);  // mybatis-plus提供的方法,表示插入数据
//        } else {
//            return updateById(user);
//        }
        return saveOrUpdate(user);
    }

    //    MybatisPlus 已经实现了
//    @Autowired
//    private UserMapper userMapper;
//
//    //业务实现，
//    public int userSave(User user) {
//        if (user.getId() == null) {
//            return userMapper.insert(user);
//        } else {
//            return userMapper.update(user);
//        }
//    }
}
