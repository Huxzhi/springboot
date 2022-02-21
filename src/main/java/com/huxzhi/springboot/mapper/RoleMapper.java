package com.huxzhi.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huxzhi.springboot.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author huxzhi
 * @since 2022-02-20
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    @Select("select id from sys_role where flag = #{flag}")
    Integer selectByFlag(@Param("flag") String flag);
}
