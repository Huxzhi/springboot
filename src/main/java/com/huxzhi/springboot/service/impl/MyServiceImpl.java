package com.huxzhi.springboot.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.huxzhi.springboot.entity.Birth;
import com.huxzhi.springboot.entity.Illegal;
import com.huxzhi.springboot.entity.Residence;
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

    @Override
    public Map getData(Integer id) {
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
}
