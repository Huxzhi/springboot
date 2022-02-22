package com.huxzhi.springboot.service.impl;

import com.huxzhi.springboot.entity.Illegal;
import com.huxzhi.springboot.mapper.IllegalMapper;
import com.huxzhi.springboot.service.IIllegalService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huxzhi
 * @since 2022-02-22
 */
@Service
public class IllegalServiceImpl extends ServiceImpl<IllegalMapper, Illegal> implements IIllegalService {

}
