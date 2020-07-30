package com.quan.controller;

import com.quan.response.Result;
import com.quan.service.TbDepartmentService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 全俊
 */
@Api("部门操作接口")
@RestController
@CrossOrigin
@RequestMapping("/department")
public class TbDepartmentController {
    @Resource
    private TbDepartmentService tbDepartmentService;

    @GetMapping("/getDepartment")
    public Result getDepartment() {
        return Result.success().data(tbDepartmentService.getDepartment());
    }
}
