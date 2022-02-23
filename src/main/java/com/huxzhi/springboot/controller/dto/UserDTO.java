package com.huxzhi.springboot.controller.dto;


import com.huxzhi.springboot.entity.Menu;
import lombok.Data;

import java.util.List;

/**
 * 接受前端登录请求的参数,专门用来传递前端和后端的数据，不会保存在数据库中
 * 和UserDTO有一部分和 Entity.user 重叠， 会进行bean 拷贝
 */
@Data
public class UserDTO {
    private Integer id;
    private String username;
    private String nickname;
    private String password;

    private String email;
    private String phone;


    private String avatarUrl;
    private String token;
    private String role;
    private List<Menu> menus;
}
