package com.huxzhi.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author huxzhi
 * @since 2022-02-22
 */
@Getter
@Setter
@TableName("fp_birth")
@ApiModel(value = "Birth对象", description = "")
public class Birth implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("身份证号")
    private String idCard;

    @ApiModelProperty("年龄")
    private Integer age;

    @ApiModelProperty("性别")
    private String gender;

    @ApiModelProperty("在读学校")
    private String school;

    @ApiModelProperty("父亲角色id")
    private Integer fatherId;

    @ApiModelProperty("母亲角色id")
    private Integer motherId;


}
