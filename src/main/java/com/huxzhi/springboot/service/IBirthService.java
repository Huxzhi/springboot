package com.huxzhi.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huxzhi.springboot.entity.Birth;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author huxzhi
 * @since 2022-02-22
 */
public interface IBirthService extends IService<Birth> {
    Integer selectUnderage();
}
