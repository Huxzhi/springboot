package com.huxzhi.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huxzhi.springboot.bean.User;

//@Mapper
public interface UserMapper extends BaseMapper<User> {

//    @Select("select * from sys_user ")
//    List<User> findAll();
//
//    @Insert("INSERT INTO sys_user(username,password,nickname,email,phone,address) VALUES" +
//            " (#{username},#{password},#{nickname},#{email},#{phone},#{address});")
//    int insert(User user);
//
//    //在配置文件定义了动态sql
//    int update(User user);
//
//    @Delete("delete from sys_user where id =#{id}")
//    Integer deleteUserById(@Param("id") Integer id);
//
//    //分页查询
//    @Select("SELECT * FROM sys_user where username like concat('%',#{username},'%') LIMIT #{pageNum},#{pageSize};")
//    List<User> selectPageUsers(Integer pageNum, Integer pageSize, String username);
//
//    @Select("select count(*) from sys_user where username like concat('%',#{username},'%') ")
//    Integer selectTotalUser(String username);
}
