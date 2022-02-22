package com.huxzhi.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2022-02-22
 */
@Getter
@Setter
@TableName("fp_illegal")
@ApiModel(value = "Illegal对象", description = "")
public class Illegal implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("订单号")
    private String order;

    @ApiModelProperty("处罚机关")
    private String punishmentAuhority;

    @ApiModelProperty("违法时间")
    private Date illegalTime;

    @ApiModelProperty("违法地点")
    private String illegalPlace;

    @ApiModelProperty("违法行为")
    private String illegalActivities;

    @ApiModelProperty("违法人员")
    private String illegalPerson;

    @ApiModelProperty("违法人员身份证号")
    private String illegalIdCard;

    @ApiModelProperty("罚款金额")
    private String forfeit;

    @ApiModelProperty("其他措施")
    private String otherMeasures;

    @ApiModelProperty("处罚时间")
    private Date penaltyTime;

    @ApiModelProperty("是否受理")
    private Boolean isAccepted;

    @ApiModelProperty("受理人")
    private String receiver;

    @ApiModelProperty("受理时间")
    private Date acceptanceTime;


}
