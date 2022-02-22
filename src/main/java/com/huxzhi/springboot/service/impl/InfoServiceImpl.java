package com.huxzhi.springboot.service.impl;

import com.huxzhi.springboot.entity.Info;
import com.huxzhi.springboot.mapper.InfoMapper;
import com.huxzhi.springboot.service.IInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huxzhi
 * @since 2022-02-21
 */
@Service
public class InfoServiceImpl extends ServiceImpl<InfoMapper, Info> implements IInfoService {

}
