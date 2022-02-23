package com.huxzhi.springboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huxzhi.springboot.entity.Birth;
import com.huxzhi.springboot.mapper.BirthMapper;
import com.huxzhi.springboot.service.IBirthService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author huxzhi
 * @since 2022-02-22
 */
@Service
public class BirthServiceImpl extends ServiceImpl<BirthMapper, Birth> implements IBirthService {
    @Resource
    BirthMapper birthMapper;

    @Override
    public Integer selectUnderage() {
        return birthMapper.selectUnderage();
    }
}
