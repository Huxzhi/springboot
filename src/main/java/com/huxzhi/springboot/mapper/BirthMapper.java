package com.huxzhi.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huxzhi.springboot.entity.Birth;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author huxzhi
 * @since 2022-02-22
 */
@Mapper
public interface BirthMapper extends BaseMapper<Birth> {
    @Select("select count(age) from fp_birth where age < 18")
    Integer selectUnderage();
}
