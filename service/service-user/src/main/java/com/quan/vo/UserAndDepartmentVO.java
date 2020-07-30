package com.quan.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 全俊
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "com-quan-vo-UserAndDepartmentVO")
public class UserAndDepartmentVO {
    /**
     * 用户ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "用户ID")
    private Long id;

    /**
     * 用户名
     */
    @TableField(value = "username")
    @ApiModelProperty(value = "用户名")
    private String username;

    /**
     * 性别 0男 1女 2保密
     */
    @TableField(value = "sex")
    @ApiModelProperty(value = "性别 0男 1女 2保密")
    private Integer sex;

    /**
     * 系名
     */
    @TableField(value = "name")
    @ApiModelProperty(value = "系名")
    private String name;

    /**
     * 生日
     */
    @TableField(value = "birth")
    @ApiModelProperty(value = "生日")
    private Date birth;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    @ApiModelProperty(value = "邮箱")
    private String email;

    /**
     * 联系电话
     */
    @TableField(value = "phone_number")
    @ApiModelProperty(value = "联系电话")
    private String phoneNumber;

    /**
     * 状态 0锁定 1有效
     */
    @TableField(value = "status")
    @ApiModelProperty(value = "状态 0锁定 1有效")
    private Integer status;
}
