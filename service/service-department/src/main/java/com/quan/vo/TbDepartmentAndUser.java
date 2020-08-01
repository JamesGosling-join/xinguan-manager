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
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "com-quan-vo-TbDepartmentAndUser")
public class TbDepartmentAndUser implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键id")
    private Long id;

    /**
     * 系办公电话
     */
    @TableField(value = "phone")
    @ApiModelProperty(value = "系办公电话")
    private String phone;

    /**
     * 系名
     */
    @TableField(value = "name")
    @ApiModelProperty(value = "系名")
    private String name;

    /**
     * 当前系人数
     */
    @TableField(value = "count")
    @ApiModelProperty(value = "当前系人数")
    private Integer count;

    /**
     * 创建时间
     */
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(value = "modified_time",fill = FieldFill.UPDATE)
    @ApiModelProperty(value = "修改时间")
    private Date modifiedTime;

    /**
     * 用户名
     */
    @TableField(value = "username")
    @ApiModelProperty(value = "部门主任")
    private String username;

    /**
     * 办公室地点
     */
    @TableField(value = "address")
    @ApiModelProperty(value = "办公室地点")
    private String address;

    private static final long serialVersionUID = 1L;
}
