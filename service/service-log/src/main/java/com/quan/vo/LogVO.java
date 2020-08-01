package com.quan.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 全俊
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "com-quan-vo-LogVO")
public class LogVO implements Serializable {
    /**
     * 操作用户
     */
    @TableField(value = "username")
    @ApiModelProperty(value = "操作用户")
    private String username;

    /**
     * 操作者IP
     */
    @TableField(value = "ip")
    @ApiModelProperty(value = "操作者IP")
    private String ip;

    /**
     * 操作地点
     */
    @TableField(value = "location")
    @ApiModelProperty(value = "操作地点")
    private String location;

    private static final long serialVersionUID = 1L;
}
