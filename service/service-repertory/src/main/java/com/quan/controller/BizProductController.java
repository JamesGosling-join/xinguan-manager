package com.quan.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.quan.response.Result;
import com.quan.service.BizProductService;
import com.quan.vo.BizProductFind;
import com.quan.vo.BizProductVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 全俊
 * @version 1.0
 * @className BizProductController
 * @description TODO
 * @date 2020/8/12 10:29
 */
@RequestMapping("/repertoryservice/bizProduc")
@Api("物资名称接口")
@RestController
@CrossOrigin
public class BizProductController {
    @Resource
    private BizProductService bizProductService;

    @ApiOperation(value = "查询所有物资信息", notes = "按条件分页查询")
    @PostMapping("{current}/{size}")
    public Result findAll(@RequestBody(required = false) BizProductFind bizProductFind,
                          @PathVariable(required = false, value = "current") Long current,
                          @PathVariable(value = "size", required = false) Long size) {
        QueryWrapper<BizProductVO> qw = new QueryWrapper<>();
        if (!StringUtils.isEmpty(bizProductFind)) {
            if (!StringUtils.isEmpty(bizProductFind.getOneCategoryId())) {
                qw.eq("one_category_id", bizProductFind.getOneCategoryId());
            }
            if (!StringUtils.isEmpty(bizProductFind.getTwoCategoryId())) {
                qw.eq("two_category_id", bizProductFind.getTwoCategoryId());
            }
            if (!StringUtils.isEmpty(bizProductFind.getThreeCategoryId())) {
                qw.eq("three_category_id", bizProductFind.getThreeCategoryId());
            }
            if (!StringUtils.isEmpty(bizProductFind.getName())) {
                qw.eq("name", bizProductFind.getName());
            }
        }
        return Result.success().data(bizProductService.findAll(new Page<>(current == null ? 1 : current, size == null ? 9 : size), qw));
    }
}
