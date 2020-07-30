package com.quan.pojo;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户表
 *
 * @author 全俊
 */
@ApiModel(value = "com-quan-pojo-TbUser")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tb_user")
public class TbUser implements Serializable {
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
     * 昵称
     */
    @TableField(value = "nickname")
    @ApiModelProperty(value = "昵称")
    private String nickname;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    @ApiModelProperty(value = "邮箱")
    private String email;

    /**
     * 头像
     */
    @TableField(value = "avatar")
    @ApiModelProperty(value = "头像")
    private String avatar;

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

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(value = "modified_time", fill = FieldFill.UPDATE)
    @ApiModelProperty(value = "修改时间")
    private Date modifiedTime;

    /**
     * 性别 0男 1女 2保密
     */
    @TableField(value = "sex")
    @ApiModelProperty(value = "性别 0男 1女 2保密")
    private Integer sex;

    /**
     * 盐
     */
    @TableField(value = "salt")
    @ApiModelProperty(value = "盐")
    private String salt;

    /**
     * 0:超级管理员，1：系统用户
     */
    @TableField(value = "type")
    @ApiModelProperty(value = "0:超级管理员，1：系统用户")
    private Integer type;

    /**
     * 密码
     */
    @TableField(value = "password")
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 生日
     */
    @TableField(value = "birth")
    @ApiModelProperty(value = "生日")
    private Date birth;

    /**
     * 部门id
     */
    @TableField(value = "department_id")
    @ApiModelProperty(value = "部门id")
    private Long departmentId;

    /**
     * 版本信息
     */
    @Version
    @TableField(value = "version")
    @ApiModelProperty(value = "版本信息")
    private Long version;

    /**
     * 逻辑删除
     */
    @TableLogic
    @TableField(value = "deleted")
    @ApiModelProperty(value = "逻辑删除")
    private Boolean deleted;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_USERNAME = "username";

    public static final String COL_NICKNAME = "nickname";

    public static final String COL_EMAIL = "email";

    public static final String COL_AVATAR = "avatar";

    public static final String COL_PHONE_NUMBER = "phone_number";

    public static final String COL_STATUS = "status";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_MODIFIED_TIME = "modified_time";

    public static final String COL_SEX = "sex";

    public static final String COL_SALT = "salt";

    public static final String COL_TYPE = "type";

    public static final String COL_PASSWORD = "password";

    public static final String COL_BIRTH = "birth";

    public static final String COL_DEPARTMENT_ID = "department_id";

    public static final String COL_VERSION = "version";

    public static final String COL_DELETED = "deleted";
}