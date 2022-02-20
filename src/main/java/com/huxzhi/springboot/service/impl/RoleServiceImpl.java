package com.huxzhi.springboot.service.impl;

import com.huxzhi.springboot.entity.Role;
import com.huxzhi.springboot.mapper.RoleMapper;
import com.huxzhi.springboot.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huxzhi
 * @since 2022-02-20
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
