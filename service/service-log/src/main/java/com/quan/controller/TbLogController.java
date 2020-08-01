package com.quan.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.quan.pojo.TbLog;
import com.quan.response.Result;
import com.quan.service.TbLogService;
import com.quan.vo.LogVO;
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
@RequestMapping("/logservice/log")
public class TbLogController {
    @Resource
    private TbLogService tbLogService;

    @ApiOperation(value = "查询所有操作日志", notes = "根据传入条件分页查询，返回分页信息")
    @PostMapping({"findAllLog", "findAllLog/{current}", "findAllLog/{current}/{size}"})
    public Result findAllLoginLog(@PathVariable(required = false) Long current, @PathVariable(required = false) Long size, @RequestBody(required = false) LogVO logVO) {
        QueryWrapper<TbLog> qw = new QueryWrapper<>();
        qw.eq("deleted", 0);
        if (!StringUtils.isEmpty(logVO)) {
            if (!StringUtils.isEmpty(logVO.getUsername())) {
                qw.like("username", logVO.getUsername());
            }
            if (!StringUtils.isEmpty(logVO.getIp())) {
                qw.like("ip", logVO.getIp());
            }
            if (!StringUtils.isEmpty(logVO.getLocation())) {
                qw.like("location", logVO.getLocation());
            }
        }
        Page<TbLog> page = tbLogService.page(new Page<>(current == null ? 1 : current, size == null ? 7 : size), qw);
        if (page.getRecords().size() == 0) {
            Long total = page.getTotal();
            size = page.getSize();
            page.setCurrent(total % size == 0 ? total / size : total / size + 1);
            page = tbLogService.page(page, qw);
        }
        return Result.success().data(page);
    }

    @ApiOperation(value = "删除日志信息", notes = "根据传入id集合批量删除")
    @PostMapping("deleteById")
    public Result deleteById(@RequestBody List<Long> list) {
        if (tbLogService.removeByIds(list)) {
            return Result.success();
        }
        return Result.fail();
    }
}
