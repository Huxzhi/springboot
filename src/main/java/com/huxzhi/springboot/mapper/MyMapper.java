package com.huxzhi.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MyMapper {
    @Select("select id_info from fp_user_info where id_user = #{id_user}")
    Integer getMyInfo(@Param("id_user") Integer id_user);

    @Select("select id_residence from fp_user_residence where id_user = #{id_user}")
    List<Integer> getMyResidence(@Param("id_user") Integer id_user);

    @Select("select id_illegal from fp_user_illegal where id_user = #{id_user}")
    List<Integer> getMyIllegal(@Param("id_user") Integer id_user);

    @Select("select id_birth from fp_user_birth where id_user = #{id_user}")
    List<Integer> getMyBirth(@Param("id_user") Integer id_user);

}
