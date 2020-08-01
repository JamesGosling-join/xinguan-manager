package com.quan.vo;

import com.alibaba.excel.annotation.ExcelProperty;
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
@ApiModel(value = "com-quan-vo-UserExcelVO")
public class UserExcelVO implements Serializable {
    /**
     * 用户ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ExcelProperty(value = "用户ID", index = 0)
    @ApiModelProperty(value = "用户ID")
    private Long id;

    /**
     * 用户名
     */
    @TableField(value = "username")
    @ExcelProperty(value = "用户名", index = 1)
    @ApiModelProperty(value = "用户名")
    private String username;

    /**
     * 昵称
     */
    @TableField(value = "nickname")
    @ExcelProperty(value = "昵称", index = 2)
    @ApiModelProperty(value = "昵称")
    private String nickname;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    @ExcelProperty(value = "邮箱", index = 3)
    @ApiModelProperty(value = "邮箱")
    private String email;

    /**
     * 头像
     */
    @TableField(value = "avatar")
    @ExcelProperty(value = "头像", index = 4)
    @ApiModelProperty(value = "头像")
    private String avatar;

    /**
     * 联系电话
     */
    @TableField(value = "phone_number")
    @ExcelProperty(value = "联系电话", index = 5)
    @ApiModelProperty(value = "联系电话")
    private String phoneNumber;

    /**
     * 状态 0锁定 1有效
     */
    @TableField(value = "status")
    @ExcelProperty(value = "状态", index = 6)
    @ApiModelProperty(value = "状态 0锁定 1有效")
    private String status;

    /**
     * 创建时间
     */
    @ExcelProperty(value = "创建时间", index = 7)
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 修改时间
     */
    @ExcelProperty(value = "修改时间", index = 8)
    @TableField(value = "modified_time", fill = FieldFill.UPDATE)
    @ApiModelProperty(value = "修改时间")
    private Date modifiedTime;

    /**
     * 性别 0男 1女 2保密
     */
    @ExcelProperty(value = "性别", index = 9)
    @TableField(value = "sex")
    @ApiModelProperty(value = "性别 0男 1女 2保密")
    private String sex;

    /**
     * 0:超级管理员，1：系统用户
     */
    @ExcelProperty(value = "用户权限", index = 10)
    @TableField(value = "type")
    @ApiModelProperty(value = "0:超级管理员，1：系统用户")
    private String type;

    /**
     * 生日
     */
    @ExcelProperty(value = "生日", index = 11)
    @TableField(value = "birth")
    @ApiModelProperty(value = "生日")
    private Date birth;

    /**
     * 系名
     */
    @TableField(value = "name")
    @ExcelProperty(value = "部门名", index = 12)
    @ApiModelProperty(value = "部门名")
    private String name;

    /**
     * 版本信息
     */
    @ExcelProperty(value = "版本信息", index = 13)
    @Version
    @TableField(value = "version")
    @ApiModelProperty(value = "版本信息")
    private Long version;

    /**
     * 逻辑删除
     */
    @ExcelProperty(value = "逻辑删除", index = 14)
    @TableLogic
    @TableField(value = "deleted")
    @ApiModelProperty(value = "逻辑删除")
    private String deleted;

    private static final long serialVersionUID = 1L;
}
