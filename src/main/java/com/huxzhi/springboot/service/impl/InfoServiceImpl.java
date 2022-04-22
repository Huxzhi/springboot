package com.huxzhi.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huxzhi.springboot.entity.Info;
import com.huxzhi.springboot.mapper.InfoMapper;
import com.huxzhi.springboot.service.IInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author huxzhi
 * @since 2022-02-21
 */
@Service
public class InfoServiceImpl extends ServiceImpl<InfoMapper, Info> implements IInfoService {

    @Resource
    private InfoMapper infoMapper;

    @Override
    public List<Integer> selectAge() {
        return infoMapper.selectAge();
    }

  
    @Override
    public Integer columnCount(String column, String val) {
        QueryWrapper<Info> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(column, val);
        return infoMapper.selectCount(queryWrapper);
    }

}
