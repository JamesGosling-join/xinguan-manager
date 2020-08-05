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
 * 登录日志表
 *
 * @author 全俊
 */
@ApiModel(value = "com-quan-pojo-TbLoginLog")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tb_login_log")
public class TbLoginLog implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 用户名
     */
    @TableField(value = "username")
    @ApiModelProperty(value = "用户名")
    private String username;

    /**
     * 登录时间
     */
    @TableField(value = "login_time",fill = FieldFill.INSERT)
    @ApiModelProperty(value = "登录时间")
    private Date loginTime;

    /**
     * 登录地点
     */
    @TableField(value = "location")
    @ApiModelProperty(value = "登录地点")
    private String location;

    /**
     * IP地址
     */
    @TableField(value = "ip")
    @ApiModelProperty(value = "IP地址")
    private String ip;

    /**
     * 操作系统
     */
    @TableField(value = "user_system")
    @ApiModelProperty(value = "操作系统")
    private String userSystem;

    /**
     * 浏览器
     */
    @TableField(value = "user_browser")
    @ApiModelProperty(value = "浏览器")
    private String userBrowser;

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

    public static final String COL_LOGIN_TIME = "login_time";

    public static final String COL_LOCATION = "location";

    public static final String COL_IP = "ip";

    public static final String COL_USER_SYSTEM = "user_system";

    public static final String COL_USER_BROWSER = "user_browser";

    public static final String COL_DELETED = "deleted";
}