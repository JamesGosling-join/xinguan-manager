package com.quan.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

/**
 * @author 全俊
 * @version 1.0
 * @className BizProductRecursion
 * @description TODO
 * @date 2020/8/12 18:25
 */
@ApiModel(value = "com-quan-vo-BizProductRecursion")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BizProductRecursion {
    /**
     * 类别id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "类别id")
    private Long value;

    /**
     * 类别名称
     */
    @TableField(value = "name")
    @ApiModelProperty(value = "类别名称")
    private String label;

    /**
     * 类别子集
     */
    @ApiModelProperty(value = "子级分类")
    private List<BizProductRecursion> children;

    /**
     * 如果集合没有数据则返回null
     *
     * @return java.util.List<com.quan.vo.BizProductRecursion>
     * @description TODO
     * @methodName getChildren
     * @author 全俊
     * @date 2020/8/13 18:25
     */
    public List<BizProductRecursion> getChildren() {
        if (children.isEmpty()) {
            return null;
        }
        return children;
    }
}
