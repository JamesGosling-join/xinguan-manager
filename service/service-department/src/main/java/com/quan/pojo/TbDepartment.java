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
 * @author 全俊
 */
@ApiModel(value = "com-quan-pojo-TbDepartment")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tb_department")
public class TbDepartment implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键id")
    private Long id;

    /**
     * 系名
     */
    @TableField(value = "name")
    @ApiModelProperty(value = "系名")
    private String name;

    /**
     * 系办公电话
     */
    @TableField(value = "phone")
    @ApiModelProperty(value = "系办公电话")
    private String phone;

    /**
     * 办公室地点
     */
    @TableField(value = "address")
    @ApiModelProperty(value = "办公室地点")
    private String address;

    /**
     * 创建时间
     */
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(value = "modified_time",fill = FieldFill.UPDATE)
    @ApiModelProperty(value = "修改时间")
    private Date modifiedTime;

    /**
     * 系主任id，关联用户表
     */
    @TableField(value = "mgr_id")
    @ApiModelProperty(value = "系主任id，关联用户表")
    private Long mgrId;

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

    public static final String COL_NAME = "name";

    public static final String COL_PHONE = "phone";

    public static final String COL_ADDRESS = "address";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_MODIFIED_TIME = "modified_time";

    public static final String COL_MGR_ID = "mgr_id";

    public static final String COL_VERSION = "version";

    public static final String COL_DELETED = "deleted";
}