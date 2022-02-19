package com.huxzhi.springboot.controller.dto;


import lombok.Data;

/**
 * 接受前端登录请求的参数
 */
@Data
public class UserDTO {
    private String username;
    private String nickname;
    private String password;

    private String email;
    private String phone;


    private String avatarUrl;
    private String token;
//    private String role;
//    private List<Menu> menus;
}
