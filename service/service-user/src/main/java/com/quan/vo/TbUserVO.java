package com.quan.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 全俊
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "com-quan-vo-TbUserVO")
public class TbUserVO implements Serializable {
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

    private static final long serialVersionUID = 1L;
}
