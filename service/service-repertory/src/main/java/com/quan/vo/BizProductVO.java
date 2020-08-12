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
 * @className BizProduct
 * @description TODO
 * @date 2020/8/12 11:22
 */
@ApiModel(value="com-quan-vo-BizProductVO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BizProductVO {
    /**
     * 图片
     */
    @TableField(value = "image_url")
    @ApiModelProperty(value="图片")
    private String imageUrl;

    /**
     * 商品名称
     */
    @TableField(value = "name")
    @ApiModelProperty(value="商品名称")
    private String name;

    /**
     * 规格型号
     */
    @TableField(value = "model")
    @ApiModelProperty(value="规格型号")
    private String model;

    /**
     * 商品库存结余
     */
    @TableField(value = "stock")
    @ApiModelProperty(value="商品库存结余")
    private Long stock;

    /**
     * 计算单位
     */
    @TableField(value = "unit")
    @ApiModelProperty(value="计算单位")
    private String unit;
}
