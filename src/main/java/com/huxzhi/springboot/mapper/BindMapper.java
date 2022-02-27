package com.huxzhi.springboot.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface BindMapper {
    @Insert("insert into fp_user_info (id_user,id_info) values (#{id_user},#{id_info})")
    Integer saveInfo(@Param("id_user") Integer id_user,
                     @Param("id_info") Integer id_info);
}