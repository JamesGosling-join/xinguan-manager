package com.quan.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.*;
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
@ApiModel(value = "com-quan-vo-TbDepartmentExcel")
public class TbDepartmentExcel implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ExcelProperty(value = "主键id",index = 0)
    @ApiModelProperty(value = "主键id")
    private Long id;

    /**
     * 系办公电话
     */
    @TableField(value = "phone")
    @ApiModelProperty(value = "系办公电话")
    @ExcelProperty(value = "系办公电话",index = 1)
    private String phone;

    /**
     * 系名
     */
    @TableField(value = "name")
    @ApiModelProperty(value = "系名")
    @ExcelProperty(value = "系名",index = 2)
    private String name;

    /**
     * 当前系人数
     */
    @TableField(value = "count")
    @ApiModelProperty(value = "当前系人数")
    @ExcelProperty(value = "当前系人数",index = 3)
    private Integer count;

    /**
     * 创建时间
     */
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    @ExcelProperty(value = "创建时间",index = 4)
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(value = "modified_time",fill = FieldFill.UPDATE)
    @ApiModelProperty(value = "修改时间")
    @ExcelProperty(value = "修改时间",index = 5)
    private Date modifiedTime;

    /**
     * 用户名
     */
    @TableField(value = "username")
    @ApiModelProperty(value = "部门主任")
    @ExcelProperty(value = "部门主任",index = 6)
    private String username;

    /**
     * 办公室地点
     */
    @TableField(value = "address")
    @ApiModelProperty(value = "办公室地点")
    @ExcelProperty(value = "办公室地点",index = 7)
    private String address;

    /**
     * 版本信息
     */
    @Version
    @TableField(value = "version")
    @ApiModelProperty(value = "版本信息")
    @ExcelProperty(value = "版本信息",index = 8)
    private Long version;

    /**
     * 逻辑删除
     */
    @TableLogic
    @TableField(value = "deleted")
    @ApiModelProperty(value = "逻辑删除")
    @ExcelProperty(value = "逻辑删除",index = 9)
    private Boolean deleted;

    private static final long serialVersionUID = 1L;
}
