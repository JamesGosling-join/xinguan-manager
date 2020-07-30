package com.quan.vo;

import com.baomidou.mybatisplus.annotation.TableField;
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
@ApiModel(value = "com-quan-vo-ReturnTbUserVO")
public class ReturnTbUserVO {
    /**
     * 用户名
     */
    @TableField(value = "username")
    @ApiModelProperty(value = "用户名")
    private String username;

    /**
     * 头像
     */
    @TableField(value = "avatar")
    @ApiModelProperty(value = "头像")
    private String avatar;
}
