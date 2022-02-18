package com.huxzhi.springboot.service.impl;

import com.huxzhi.springboot.entity.User;
import com.huxzhi.springboot.mapper.UserMapper;
import com.huxzhi.springboot.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huxzhi
 * @since 2022-02-18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
