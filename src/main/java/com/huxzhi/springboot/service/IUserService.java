package com.huxzhi.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huxzhi.springboot.controller.dto.UserDTO;
import com.huxzhi.springboot.entity.User;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author huxzhi
 * @since 2022-02-18
 */
public interface IUserService extends IService<User> {

    boolean login(UserDTO userDTO);
}
