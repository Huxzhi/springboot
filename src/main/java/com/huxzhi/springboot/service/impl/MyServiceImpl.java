package com.huxzhi.springboot.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.huxzhi.springboot.common.Constants;
import com.huxzhi.springboot.controller.dto.PostResidenceDTO;
import com.huxzhi.springboot.entity.Birth;
import com.huxzhi.springboot.entity.Illegal;
import com.huxzhi.springboot.entity.Residence;
import com.huxzhi.springboot.exception.ServiceException;
import com.huxzhi.springboot.mapper.*;
import com.huxzhi.springboot.service.MyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MyServiceImpl implements MyService {

    @Resource
    private MyMapper myMapper;

    @Resource
    private InfoMapper infoMapper;
    @Resource
    private IllegalMapper illegalMapper;
    @Resource
    private ResidenceMapper residenceMapper;
    @Resource
    private BirthMapper birthMapper;

    @Resource
    private BindMapper bindMapper;

    @Override
    public Map getData(Integer id) {
        //todo: 处理一下数据库找不到连接数据id的异常
        Integer myInfo = myMapper.getMyInfo(id);
        List<Integer> myIllegal = myMapper.getMyIllegal(id);
        List<Integer> myResidence = myMapper.getMyResidence(id);
        List<Integer> myBirth = myMapper.getMyBirth(id);
        List<Illegal> illegals = CollUtil.newArrayList();
        for (Integer i : myIllegal) {
            illegals.add(illegalMapper.selectById(i));
        }
        List<Residence> residences = CollUtil.newArrayList();
        for (Integer i : myResidence) {
            residences.add(residenceMapper.selectById(i));
        }
        List<Birth> births = CollUtil.newArrayList();
        for (Integer i : myBirth) {
            births.add(birthMapper.selectById(i));
        }
        Map<String, Object> map = new HashMap<>();
        map.put("info", infoMapper.selectById(myInfo));
        map.put("illegals", illegals);
        map.put("residences", residences);
        map.put("births", births);
        return map;
    }

    @Override
    public void postResidence(PostResidenceDTO postResidenceDTO) {
        Residence one = new Residence();
        //拷贝JavaBean，将postResidenceDTO数据传输对象的内容赋给Residence实体
        BeanUtil.copyProperties(postResidenceDTO, one, true);
        //判断是否有违法记录，有违法记录的返回 添加错误，请先处理违法记录
        Integer i = myMapper.selectIllegal(postResidenceDTO.getUserId());
        if (i > 0) {
            throw new ServiceException(Constants.CODE_500, "存在违法记录，请先处理违法记录");
        }
        //添加绑定数据，会自动返回id
        residenceMapper.insert(one);
        //将暂住证Id和userId绑定
        Integer update = bindMapper.saveResidence(postResidenceDTO.getUserId(), one.getId());
        if (update < 1) {
            throw new ServiceException(Constants.CODE_500, "绑定的数据缺失，请联系管理员");
        }
    }
}
