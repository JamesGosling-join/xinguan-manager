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
@ApiModel(value = "com-quan-vo-LoginVO")
public class LoginVO implements Serializable {
    /**
     * 验证码
     */
    @ApiModelProperty(value = "验证码")
    private String code;

    /**
     * 验证码的键
     */
    @ApiModelProperty(value = "验证码的键")
    private String key;

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

    private static final long serialVersionUID = 1L;
}
