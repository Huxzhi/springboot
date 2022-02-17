package com.huxzhi.springboot.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "sys_user") // mybatis-plus 数据库表名
public class User {

    @TableId(value = "id", type = IdType.AUTO) // mybatis-plus 指定主键
    private Integer id;
    private String username;
    @JsonIgnore //忽略某个字段，不展示给前端
    private String password;
    private String nickname;
    private String email;
    private String phone;

    @TableField(value = "address")// mybatis-plus 取别名，指定数据库的字段名称
    private String address;

}
