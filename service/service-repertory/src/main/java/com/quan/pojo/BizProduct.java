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
@ApiModel(value="com-quan-pojo-BizProduct")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "biz_product")
public class BizProduct implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="")
    private Long id;

    /**
     * 商品编号
     */
    @TableField(value = "p_num")
    @ApiModelProperty(value="商品编号")
    private String pNum;

    /**
     * 商品名称
     */
    @TableField(value = "name")
    @ApiModelProperty(value="商品名称")
    private String name;

    /**
     * 图片
     */
    @TableField(value = "image_url")
    @ApiModelProperty(value="图片")
    private String imageUrl;

    /**
     * 规格型号
     */
    @TableField(value = "model")
    @ApiModelProperty(value="规格型号")
    private String model;

    /**
     * 计算单位
     */
    @TableField(value = "unit")
    @ApiModelProperty(value="计算单位")
    private String unit;

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

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(value = "modified_time")
    @ApiModelProperty(value="修改时间")
    private Date modifiedTime;

    /**
     * 1级分类
     */
    @TableField(value = "one_category_id")
    @ApiModelProperty(value="1级分类")
    private Long oneCategoryId;

    /**
     * 2级分类
     */
    @TableField(value = "two_category_id")
    @ApiModelProperty(value="2级分类")
    private Long twoCategoryId;

    /**
     * 3级分类
     */
    @TableField(value = "three_category_id")
    @ApiModelProperty(value="3级分类")
    private Long threeCategoryId;

    /**
     * 是否删除:1物资正常,0:物资回收,2:物资审核中
     */
    @TableField(value = "status")
    @ApiModelProperty(value="是否删除:1物资正常,0:物资回收,2:物资审核中")
    private Integer status;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_P_NUM = "p_num";

    public static final String COL_NAME = "name";

    public static final String COL_IMAGE_URL = "image_url";

    public static final String COL_MODEL = "model";

    public static final String COL_UNIT = "unit";

    public static final String COL_REMARK = "remark";

    public static final String COL_SORT = "sort";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_MODIFIED_TIME = "modified_time";

    public static final String COL_ONE_CATEGORY_ID = "one_category_id";

    public static final String COL_TWO_CATEGORY_ID = "two_category_id";

    public static final String COL_THREE_CATEGORY_ID = "three_category_id";

    public static final String COL_STATUS = "status";
}