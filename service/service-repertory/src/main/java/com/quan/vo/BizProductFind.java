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
 * @className BizProductFind
 * @description TODO
 * @date 2020/8/12 11:32
 */
@ApiModel(value="com-quan-vo-BizProductFind")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BizProductFind {
    /**
     * 1级分类
     */
    @TableField(value = "one_category_id")
    @ApiModelProperty(value = "1级分类")
    private Long oneCategoryId;

    /**
     * 2级分类
     */
    @TableField(value = "two_category_id")
    @ApiModelProperty(value = "2级分类")
    private Long twoCategoryId;

    /**
     * 3级分类
     */
    @TableField(value = "three_category_id")
    @ApiModelProperty(value = "3级分类")
    private Long threeCategoryId;

    /**
     * 商品名称
     */
    @TableField(value = "name")
    @ApiModelProperty(value = "商品名称")
    private String name;
}
