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
@ApiModel(value = "com-quan-vo-LoginLogVO")
public class LoginLogVO implements Serializable {
    /**
     * 用户名
     */
    @TableField(value = "username")
    @ApiModelProperty(value = "用户名")
    private String username;

    /**
     * IP地址
     */
    @TableField(value = "ip")
    @ApiModelProperty(value = "IP地址")
    private String ip;

    /**
     * 登录地点
     */
    @TableField(value = "location")
    @ApiModelProperty(value = "登录地点")
    private String location;

    private static final long serialVersionUID = 1L;
}
