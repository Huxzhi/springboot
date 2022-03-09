package com.huxzhi.springboot.controller.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 接受前端登录请求的参数,专门用来传递前端和后端的数据，不会保存在数据库中
 * 和UserDTO有一部分和 Entity.user 重叠， 会进行bean 拷贝
 */
@Data
public class PostResidenceDTO implements Serializable {

    //比 PostResidence 多一个 userId
    private Integer userId;

    private Integer id;
    private String name;
    private String gender;
    private String idCard;
    private String occupation;
    private String work;
    private String landlord;
    private String place;
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date timeStart;
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date timeEnd;
}
