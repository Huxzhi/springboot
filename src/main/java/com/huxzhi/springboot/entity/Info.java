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
 * @since 2022-02-21
 */
@Getter
@Setter
@TableName("fp_info")
@ApiModel(value = "Info对象", description = "")
public class Info implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("真实姓名")
    private String infoname;

    @ApiModelProperty("年龄")
    private Integer age;

    @ApiModelProperty("性别")
    private String gender;

    @ApiModelProperty("民族")
    private String nation;

    @ApiModelProperty("身份证号")
    private String idCard;

    @ApiModelProperty("政治面貌")
    private String politicalOutlook;

    @ApiModelProperty("婚姻状况")
    private String marital;

    @ApiModelProperty("现居地")
    private String currentSidence;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("是否为高级技术人才")
    private Boolean isSeniorTechnician;

    @ApiModelProperty("是否残疾")
    private Boolean isDisability;

    @ApiModelProperty("是否军人")
    private Boolean isSoldier;

    @ApiModelProperty("是否外国人")
    private Boolean isForeigner;
    
}
