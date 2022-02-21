package com.huxzhi.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huxzhi.springboot.controller.dto.UserPasswordDTO;
import com.huxzhi.springboot.entity.User;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author huxzhi
 * @since 2022-02-18
 */
public interface UserMapper extends BaseMapper<User> {
    @Update("update sys_user set password = #{newPassword} where username = #{username} and password = #{password}")
    int updatePassword(UserPasswordDTO userPasswordDTO);
}
