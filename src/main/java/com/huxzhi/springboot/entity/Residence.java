package com.huxzhi.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author huxzhi
 * @since 2022-02-23
 */
@Getter
@Setter
@TableName("fp_residence")
@ApiModel(value = "Residence对象", description = "")
public class Residence implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("性别")
    private String gender;

    @ApiModelProperty("身份证号")
    private String idCard;

    @ApiModelProperty("从业学位及职业")
    private String occupation;

    @ApiModelProperty("原工作单位")
    private String work;

    @ApiModelProperty("房东")
    private String landlord;

    @ApiModelProperty("暂住地址")
    private String place;

    @ApiModelProperty("有效日期开始")
    private Date timeStart;

    @ApiModelProperty("有效日期结束")
    private Date timeEnd;


}
