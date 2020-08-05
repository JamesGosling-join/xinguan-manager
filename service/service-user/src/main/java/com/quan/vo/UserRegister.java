package com.quan.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 全俊
 * @version 1.0
 * @className UserRegister
 * @description TODO
 * @date 2020/8/4 15:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "com-quan-vo-UserRegister")
public class UserRegister {
    /**
     * 验证码
     */
    private String code;

    /**
     * 用户名
     */
    @TableField(value = "username")
    @ApiModelProperty(value = "用户名")
    private String username;

    /**
     * 密码
     */
    @TableField(value = "password")
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 联系电话
     */
    @TableField(value = "phone_number")
    @ApiModelProperty(value = "联系电话")
    private String phoneNumber;
}
