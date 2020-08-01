package com.quan.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.quan.pojo.TbLoginLog;
import com.quan.response.Result;
import com.quan.service.TbLoginLogService;
import com.quan.vo.LoginLogVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 全俊
 */
@Api("登录日志管理")
@RestController
@CrossOrigin
@RequestMapping("/logservice/loginLog")
public class TbLoginLogController {
    @Resource
    private TbLoginLogService tbLoginLogService;

    @ApiOperation(value = "查询所有登录日志", notes = "根据传入条件分页查询,返回分页信息")
    @PostMapping({"findAllLog/{current}/{size}", "findAllLog", "findAllLog/{current}"})
    public Result findAllLoginLog(@PathVariable(required = false) Long current, @PathVariable(required = false) Long size, @RequestBody(required = false) LoginLogVO loginLogVO) {
        QueryWrapper<TbLoginLog> qw = new QueryWrapper<>();
        qw.eq("deleted", 0);
        if (!StringUtils.isEmpty(loginLogVO)) {
            if (!StringUtils.isEmpty(loginLogVO.getUsername())) {
                qw.like("username", loginLogVO.getUsername());
            }
            if (!StringUtils.isEmpty(loginLogVO.getIp())) {
                qw.like("ip", loginLogVO.getIp());
            }
            if (!StringUtils.isEmpty(loginLogVO.getLocation())) {
                qw.like("location", loginLogVO.getLocation());
            }
        }
        Page<TbLoginLog> page = tbLoginLogService.page(new Page<>(current == null ? 1 : current, size == null ? 7 : size), qw);
        if (page.getRecords().size() == 0) {
            Long total = page.getTotal();
            size = page.getSize();
            page.setCurrent(total % size == 0 ? total / size : total / size + 1);
            page = tbLoginLogService.page(page, qw);
        }
        return Result.success().data(page);
    }

    @ApiOperation(value = "删除登录日志信息", notes = "根据传入id集合批量删除")
    @PostMapping("deleteById")
    public Result deleteById(@RequestBody List<Long> list) {
        if (tbLoginLogService.removeByIds(list)) {
            return Result.success();
        }
        return Result.fail();
    }
}
