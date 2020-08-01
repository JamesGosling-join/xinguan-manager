package com.quan.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel(value = "com-quan-vo-TbUserEditVO")
public class TbUserEditVO implements Serializable {
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
     * 性别 0男 1女 2保密
     */
    @TableField(value = "sex")
    @ApiModelProperty(value = "性别 0男 1女 2保密")
    private Integer sex;

    /**
     * 部门id
     */
    @TableField(value = "department_id")
    @ApiModelProperty(value = "部门id")
    private Long departmentId;

    /**
     * 联系电话
     */
    @TableField(value = "phone_number")
    @ApiModelProperty(value = "联系电话")
    private String phoneNumber;

    /**
     * 生日
     */
    @TableField(value = "birth")
    @ApiModelProperty(value = "生日")
    private Date birth;

    /**
     * 状态 0锁定 1有效
     */
    @TableField(value = "status")
    @ApiModelProperty(value = "状态 0锁定 1有效")
    private Integer status;

    private static final long serialVersionUID = 1L;
}
