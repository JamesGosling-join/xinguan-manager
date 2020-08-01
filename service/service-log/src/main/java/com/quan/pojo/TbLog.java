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
 * 操作日志表
 *
 * @author 全俊
 */
@ApiModel(value = "com-quan-pojo-TbLog")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tb_log")
public class TbLog implements Serializable {
    /**
     * 日志ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "日志ID")
    private Long id;

    /**
     * 操作用户
     */
    @TableField(value = "username")
    @ApiModelProperty(value = "操作用户")
    private String username;

    /**
     * 操作内容
     */
    @TableField(value = "operation")
    @ApiModelProperty(value = "操作内容")
    private String operation;

    /**
     * 耗时
     */
    @TableField(value = "time")
    @ApiModelProperty(value = "耗时")
    private Long time;

    /**
     * 操作方法
     */
    @TableField(value = "method")
    @ApiModelProperty(value = "操作方法")
    private String method;

    /**
     * 方法参数
     */
    @TableField(value = "params")
    @ApiModelProperty(value = "方法参数")
    private String params;

    /**
     * 操作者IP
     */
    @TableField(value = "ip")
    @ApiModelProperty(value = "操作者IP")
    private String ip;

    /**
     * 创建时间
     */
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 操作地点
     */
    @TableField(value = "location")
    @ApiModelProperty(value = "操作地点")
    private String location;

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

    public static final String COL_OPERATION = "operation";

    public static final String COL_TIME = "time";

    public static final String COL_METHOD = "method";

    public static final String COL_PARAMS = "params";

    public static final String COL_IP = "ip";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_LOCATION = "location";

    public static final String COL_VERSION = "version";

    public static final String COL_DELETED = "deleted";
}