package com.huxzhi.springboot.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String username;
    @JsonIgnore //忽略某个字段，不展示给前端
    private String password;
    private String nickname;
    private String email;
    private String phone;
    private String address;

}
