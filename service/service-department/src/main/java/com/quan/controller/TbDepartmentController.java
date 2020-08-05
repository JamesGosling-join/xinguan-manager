package com.quan.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.quan.pojo.TbDepartment;
import com.quan.response.Result;
import com.quan.service.TbDepartmentService;
import com.quan.vo.TbDepartmentAndUser;
import com.quan.vo.TbDepartmentEdit;
import com.quan.vo.TbDepartmentExcel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 全俊
 */
@Api("部门操作接口")
@RestController
@CrossOrigin
@RequestMapping("/departmentservice/department")
public class TbDepartmentController {
    @Resource
    private TbDepartmentService tbDepartmentService;

    @ApiOperation(value = "查询部门信息", notes = "查询部门名，id,和部门人数")
    @GetMapping("/getDepartment")
    public Result getDepartment() {
        return Result.success().data(tbDepartmentService.getDepartment());
    }

    @ApiOperation(value = "查询所有部门信息", notes = "根据传入部门名称模糊查询部门信息，返回分页信息")
    @GetMapping({"findAll", "findAll/{current}/{size}"})
    public Result findAll(@PathVariable(required = false) Long current,
                          @PathVariable(required = false) Long size,
                          @RequestParam(required = false) String name) {
        QueryWrapper<TbDepartmentAndUser> qw = new QueryWrapper<>();
        getQueryWrapper(qw, name);
        qw.eq("d.deleted", 0);
        if (!StringUtils.isEmpty(name)) {
            qw.like("name", name);
        }
        return Result.success().data(tbDepartmentService.findAll(new Page<>(current, size), qw));
    }

    @ApiOperation(value = "根据id查询部门信息", notes = "根据id查询部门信息,返回查到的用户信息")
    @GetMapping("findDepartmentById/{id}")
    public Result findDepartmentById(@PathVariable(required = false) Long id) {
        return Result.success().data(tbDepartmentService.getById(id));
    }

    @ApiOperation(value = "根据id删除部门信息", notes = "返回删除结果")
    @DeleteMapping("delById/{id}")
    public Result delById(@PathVariable(required = false) Long id) {
        if (tbDepartmentService.removeById(id)) {
            return Result.success();
        }
        return Result.fail();
    }

    @ApiOperation(value = "新增部门信息", notes = "返回新增结果")
    @PostMapping("add")
    public Result add(@RequestBody(required = false) TbDepartmentEdit tbDepartmentEdit) {
        if (tbDepartmentService.selectCount(tbDepartmentEdit.getName()) > 0) {
            throw new RuntimeException("该部门已存在");
        }
        TbDepartment tbDepartment = new TbDepartment();
        BeanUtils.copyProperties(tbDepartmentEdit, tbDepartment);
        if (tbDepartmentService.save(tbDepartment)) {
            return Result.success();
        }
        return Result.fail();
    }

    @ApiOperation(value = "修改部门信息", notes = "返回修改结果")
    @PutMapping("updById")
    public Result updById(@RequestBody(required = false) TbDepartmentEdit tbDepartmentEdit) {
        QueryWrapper<TbDepartment> qw = new QueryWrapper<>();
        qw.eq("id", tbDepartmentEdit.getId());
        qw.eq("name", tbDepartmentEdit.getName());
        if (tbDepartmentService.count(qw) <= 0 && tbDepartmentService.selectCount(tbDepartmentEdit.getName()) > 0) {
            throw new RuntimeException("该部门已存在");
        }
        TbDepartment tbDepartment = new TbDepartment();
        BeanUtils.copyProperties(tbDepartmentEdit, tbDepartment);
        if (tbDepartmentService.updateById(tbDepartment)) {
            return Result.success();
        }
        return Result.fail();
    }

    @ApiOperation(value = "导出excel",notes = "根据查询条件导出部门信息")
    @GetMapping(value = "export")
    public void exportExcel(HttpServletResponse response, @RequestParam(required = false) String name) throws IOException {
        QueryWrapper<TbDepartmentExcel> qw = new QueryWrapper<>();
        getQueryWrapper(qw, name);
        tbDepartmentService.findListExcel(response, qw);
    }

    private void getQueryWrapper(QueryWrapper<?> qw, String name) {
        if (!StringUtils.isEmpty(name)) {
            qw.like("name", name);
        }
    }
}
