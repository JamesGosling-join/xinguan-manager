package com.quan.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 全俊
 */
@ApiModel(value="com-quan-pojo-BizProductStock")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "biz_product_stock")
public class BizProductStock implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="")
    private Long id;

    @TableField(value = "p_num")
    @ApiModelProperty(value="")
    private String pNum;

    /**
     * 商品库存结余
     */
    @TableField(value = "stock")
    @ApiModelProperty(value="商品库存结余")
    private Long stock;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_P_NUM = "p_num";

    public static final String COL_STOCK = "stock";
}