package com.quan.controller;

import com.quan.response.Result;
import com.quan.service.BizProductCategoryService;
import com.quan.vo.BizProductRecursion;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 全俊
 * @version 1.0
 * @className BizProductCategoryController
 * @description TODO
 * @date 2020/8/12 10:27
 */
@RequestMapping("/repertoryservice/bizProductCategory")
@Api("物资分类接口")
@RestController
@CrossOrigin
public class BizProductCategoryController {
    @Resource
    private BizProductCategoryService bizProductCategoryService;

    @ApiOperation(value = "查找所有分类信息", notes = "递归查找")
    @GetMapping
    public Result findCategory() {
        return Result.success().data(bizProductCategoryService.findCategory());
    }
}
