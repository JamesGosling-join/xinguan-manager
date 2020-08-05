package com.quan.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.quan.md5.MD5Utils;
import com.quan.pojo.TbUser;
import com.quan.random.RandomUtil;
import com.quan.response.Result;
import com.quan.service.TbUserService;
import com.quan.util.SMSClientUtils;
import com.quan.util.TbUserUtils;
import com.quan.vo.LoginVO;
import com.quan.vo.ReturnTbUserVO;
import com.quan.vo.UserRegister;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author 全俊
 */
@Api("登录接口")
@RestController
@CrossOrigin
@RequestMapping("/userservice/login")
public class LoginController {
    @Resource
    private TbUserService tbUserService;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

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
        return Result.success().data(tbUser.getId());
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

    @ApiOperation("短信验证")
    @PostMapping("sendSMS")
    public Result sendSMS(@RequestParam String phoneNumber) {
        QueryWrapper<TbUser> qw=new QueryWrapper<>();
        qw.eq("phone_number",phoneNumber);
        if(tbUserService.selectCount(qw)>0){
            throw new RuntimeException("该手机号已被注册");
        }
        String code = stringRedisTemplate.opsForValue().get(phoneNumber);
        if (!StringUtils.isEmpty(code)) {
            return Result.success();
        } else {
            String sixBitRandom = RandomUtil.getSixBitRandom();
            String templateParam = "{code:" + sixBitRandom + "}";
            if (new SMSClientUtils().send(phoneNumber, templateParam)) {
                stringRedisTemplate.opsForValue().set(phoneNumber, sixBitRandom, 5, TimeUnit.MINUTES);
                return Result.success();
            } else {
                return Result.fail();
            }
        }
    }

    @ApiOperation(value = "注册账号", notes = "使用短信验证")
    @PostMapping("register")
    public Result register(@RequestBody UserRegister userRegister) {
        String code = stringRedisTemplate.opsForValue().get(userRegister.getPhoneNumber());
        if (StringUtils.isEmpty(code)) {
            throw new RuntimeException("验证码已过期");
        }
        if (!code.equalsIgnoreCase(userRegister.getCode())) {
            throw new RuntimeException("验证码错误");
        }
        QueryWrapper<TbUser> qw=new QueryWrapper<>();
        qw.eq("username",userRegister.getUsername());
        if (tbUserService.selectCount(qw) > 0) {
            throw new RuntimeException("该用户名已被占用");
        }
        TbUser tbUser = new TbUser();
        BeanUtils.copyProperties(userRegister, tbUser);
        TbUserUtils.addUtil(tbUser);
        if (tbUserService.save(tbUser)) {
            return Result.success().data(tbUser.getId());
        } else {
            return Result.fail();
        }
    }
}
