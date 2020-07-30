package com.quan.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.quan.md5.MD5Utils;
import com.quan.pojo.TbUser;
import com.quan.response.Result;
import com.quan.service.TbUserService;
import com.quan.vo.LoginVO;
import com.quan.vo.ReturnTbUserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 全俊
 */
@Api("登录接口")
@RestController
@CrossOrigin
@RequestMapping("/login")
public class LoginController {
    @Resource
    private TbUserService tbUserService;

    @ApiOperation(value = "登录", notes = "验证登录")
    @PostMapping("/")
    public Result login(@RequestBody LoginVO loginVO) {
        QueryWrapper<TbUser> qw = new QueryWrapper<>();
        qw.eq("username", loginVO.getUsername());
        TbUser user = tbUserService.getOne(qw);
        if (StringUtils.isEmpty(user)) {
            throw new RuntimeException("账号名或密码不对");
        }
        loginVO.setPassword(MD5Utils.md5Encryption(loginVO.getPassword(), user.getSalt()));
        qw.eq("password", loginVO.getPassword());
        TbUser tbUser = tbUserService.getOne(qw);
        if (StringUtils.isEmpty(tbUser)) {
            throw new RuntimeException("账号名或密码不对");
        }
        if (tbUser.getStatus() == 0) {
            throw new RuntimeException("该账户已被禁用");
        }
        Long token = tbUser.getId();
        return Result.success().data(token);
    }

    @ApiOperation(value = "获得用户信息", notes = "获取当前登录用户信息")
    @GetMapping("user")
    public Result getUser(@RequestParam Long token) {
        TbUser tbUser = tbUserService.getById(token);
        if (StringUtils.isEmpty(tbUser)) {
            throw new RuntimeException("当前用户不存在");
        } else {
            ReturnTbUserVO returnTbUserVO = new ReturnTbUserVO(tbUser.getUsername(), tbUser.getAvatar());
            return Result.success().data(returnTbUserVO);
        }
    }

    @ApiOperation(value = "注销", notes = "注销用户,退出")
    @PostMapping("loginOut")
    public Result loginOut() {
        return Result.success();
    }
}
