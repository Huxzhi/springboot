package com.huxzhi.springboot.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;


public interface BindMapper {
    @Insert("insert into fp_user_info (id_user,id_info) values (#{id_user},#{id_info})")
    Integer saveInfo(@Param("id_user") Integer id_user,
                     @Param("id_info") Integer id_info);

    @Insert("insert into fp_user_illegal (id_user,id_illegal) values (#{id_user},#{id_illegal})")
    Integer saveIllegal(@Param("id_user") Integer id_user,
                        @Param("id_illegal") Integer id_illegal);

    @Insert("insert into fp_user_residence (id_user,id_residence) values (#{id_user},#{id_residence})")
    Integer saveResidence(@Param("id_user") Integer id_user,
                          @Param("id_residence") Integer id_residence);

    @Insert("insert into fp_user_birth (id_user,id_birth) values (#{id_user},#{id_birth})")
    Integer saveBirth(@Param("id_user") Integer id_user,
                      @Param("id_birth") Integer id_birth);

}