package com.huxzhi.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huxzhi.springboot.entity.Info;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author huxzhi
 * @since 2022-02-21
 */
@Mapper
public interface InfoMapper extends BaseMapper<Info> {
    @Select("select age from fp_info")
    List<Integer> selectAge();
}
