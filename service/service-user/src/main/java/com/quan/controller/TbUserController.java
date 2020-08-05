package com.quan.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.quan.pojo.TbUser;
import com.quan.response.Result;
import com.quan.service.TbUserService;
import com.quan.util.OSSClientUtils;
import com.quan.util.TbUserUtils;
import com.quan.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 全俊
 */
@CrossOrigin
@Api("用户管理")
@RestController
@RequestMapping("/userservice/user")
public class TbUserController {
    @Resource
    private TbUserService tbUserService;

    @Resource
    private OSSClientUtils ossClientUtils;

    @ApiOperation(value = "查询用户", notes = "跟据查询页数与个数分页查询所有用户信息，按照条件查询")
    @PostMapping({"users/{current}/{size}", "users", "users/{current}"})
    public Result userPageCondition(@PathVariable(value = "current", required = false) Long current,
                                    @PathVariable(value = "size", required = false) Long size,
                                    @RequestBody(required = false) TbUserVO tbUserVO) {
        QueryWrapper<UserAndDepartmentVO> qw = new QueryWrapper<>();
        getQueryWrapper(qw, tbUserVO);
        qw.eq("u.deleted", 0);
        qw.eq("d.deleted", 0);
        return Result.success()
                .data(tbUserService.findAll(new Page<>(current == null ? 1L : current, size == null ? 5L : size), qw));
    }

    @ApiOperation(value = "删除用户", notes = "跟据用户id逻辑删除用户信息")
    @DeleteMapping("del/{id}")
    public Result delete(@PathVariable Long id) {
        if (tbUserService.removeById(id)) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }

    @ApiOperation(value = "根据id查询", notes = "查询当前id用户信息")
    @GetMapping("getById/{id}")
    public Result getById(@PathVariable Long id) {
        TbUser tbUser = tbUserService.getById(id);
        if (StringUtils.isEmpty(tbUser)) {
            return Result.fail();
        } else {
            return Result.success().data(tbUser);
        }
    }

    @ApiOperation(value = "新增用户信息", notes = "新增用户信息")
    @PostMapping("add")
    public Result add(@RequestBody(required = false) TbUserAddVO tbUserAddVO) {
        TbUserUtils.setTbUser(tbUserService,tbUserAddVO.getUsername());
        TbUser tbUser = new TbUser();
        BeanUtils.copyProperties(tbUserAddVO, tbUser);
        TbUserUtils.addUtil(tbUser);
        if (tbUserService.save(tbUser)) {
            System.out.println("主键"+tbUser.getId());
            return Result.success();
        } else {
            return Result.fail();
        }
    }

    @ApiOperation(value = "修改用户信息", notes = "根据id修改用户信息")
    @PutMapping("updById")
    public Result updById(@RequestBody(required = false) TbUserEditVO tbUserEditVO) {
        TbUser tbUser = new TbUser();
        BeanUtils.copyProperties(tbUserEditVO, tbUser);
        if (tbUserService.updateById(tbUser)) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }

    @ApiOperation(value = "导出excel",notes = "根据查询条件将查询结果导出为excel")
    @PostMapping(value = "export")
    public void exportExcel(HttpServletResponse response,
                            @RequestBody(required = false) TbUserVO tbUserVO) throws IOException {
        QueryWrapper<UserExcelVO> qw = new QueryWrapper<>();
        getQueryWrapper(qw, tbUserVO);
        tbUserService.findListExcel(response, qw);
    }

    @ApiOperation(value = "查找部门主任", notes = "返回用户id和用户名")
    @GetMapping(value = "getMgrUser")
    public Result getMgrUser() {
        return Result.success().data(tbUserService.findMgrUser());
    }

    private void getQueryWrapper(QueryWrapper<?> qw, TbUserVO tbUserVO) {
        if (!StringUtils.isEmpty(tbUserVO)) {
            if (!StringUtils.isEmpty(tbUserVO.getUsername())) {
                qw.like("username", tbUserVO.getUsername().trim());
            }
            if (!StringUtils.isEmpty(tbUserVO.getEmail())) {
                qw.like("email", tbUserVO.getEmail().trim());
            }
            if (!StringUtils.isEmpty(tbUserVO.getSex())) {
                qw.eq("sex", tbUserVO.getSex());
            }
            if (!StringUtils.isEmpty(tbUserVO.getNickname())) {
                qw.like("nickname", tbUserVO.getNickname().trim());
            }
            if (!StringUtils.isEmpty(tbUserVO.getDepartmentId())) {
                qw.eq("department_id", tbUserVO.getDepartmentId());
            }
        }
    }

    @ApiOperation(value = "上传头像",notes = "将图片上传到OSS")
    @PostMapping("uploadImg/{username}")
    public Result uploadImg(MultipartFile file, @PathVariable String username) {
        String avatar = ossClientUtils.upload(file);
        UpdateWrapper<TbUser> uw=new UpdateWrapper<>();
        uw.set("avatar",avatar);
        uw.eq("username",username);
        tbUserService.update(uw);
        return Result.success().data(avatar);
    }
}
