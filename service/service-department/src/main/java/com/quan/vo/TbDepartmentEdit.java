package com.quan.vo;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 全俊
 */
@ApiModel(value = "com-quan-pojo-TbDepartmentEdit")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbDepartmentEdit implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键id")
    private Long id;

    /**
     * 系名
     */
    @TableField(value = "name")
    @ApiModelProperty(value = "系名")
    private String name;

    /**
     * 系办公电话
     */
    @TableField(value = "phone")
    @ApiModelProperty(value = "系办公电话")
    private String phone;

    /**
     * 办公室地点
     */
    @TableField(value = "address")
    @ApiModelProperty(value = "办公室地点")
    private String address;

    /**
     * 系主任id，关联用户表
     */
    @TableField(value = "mgr_id")
    @ApiModelProperty(value = "系主任id，关联用户表")
    private Long mgrId;

    private static final long serialVersionUID = 1L;
}