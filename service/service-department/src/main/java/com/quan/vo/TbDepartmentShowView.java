package com.quan.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 全俊
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "com-quan-vo-TbDepartmentShowView")
public class TbDepartmentShowView {
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
     * 当前系人数
     */
    @TableField(value = "count")
    @ApiModelProperty(value = "当前系人数")
    private Integer count;
}
