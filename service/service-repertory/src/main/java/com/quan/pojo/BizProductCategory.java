package com.quan.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@ApiModel(value="com-quan-pojo-BizProductCategory")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "biz_product_category")
public class BizProductCategory implements Serializable {
    /**
     * 类别id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="类别id")
    private Long id;

    /**
     * 类别名称
     */
    @TableField(value = "name")
    @ApiModelProperty(value="类别名称")
    private String name;

    /**
     * 备注
     */
    @TableField(value = "remark")
    @ApiModelProperty(value="备注")
    private String remark;

    /**
     * 排序
     */
    @TableField(value = "sort")
    @ApiModelProperty(value="排序")
    private Integer sort;

    @TableField(value = "create_time")
    @ApiModelProperty(value="")
    private Date createTime;

    @TableField(value = "modified_time")
    @ApiModelProperty(value="")
    private Date modifiedTime;

    /**
     * 父级分类id
     */
    @TableField(value = "pid")
    @ApiModelProperty(value="父级分类id")
    private Long pid;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_NAME = "name";

    public static final String COL_REMARK = "remark";

    public static final String COL_SORT = "sort";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_MODIFIED_TIME = "modified_time";

    public static final String COL_PID = "pid";
}