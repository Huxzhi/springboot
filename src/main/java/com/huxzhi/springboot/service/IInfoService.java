package com.huxzhi.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huxzhi.springboot.entity.Info;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author huxzhi
 * @since 2022-02-21
 */
public interface IInfoService extends IService<Info> {

    List<Integer> selectAge();
}
