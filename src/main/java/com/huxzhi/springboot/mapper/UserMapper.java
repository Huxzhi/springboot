package com.huxzhi.springboot.mapper;

import com.huxzhi.springboot.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface UserMapper {

    @Select("select * from sys_user ")
    List<User> findAll();
}
