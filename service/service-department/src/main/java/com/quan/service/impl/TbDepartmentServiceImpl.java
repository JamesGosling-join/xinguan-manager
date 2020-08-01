package com.quan.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.quan.vo.TbDepartmentAndUser;
import com.quan.vo.TbDepartmentExcel;
import com.quan.vo.TbDepartmentShowView;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quan.mapper.TbDepartmentMapper;
import com.quan.pojo.TbDepartment;
import com.quan.service.TbDepartmentService;

import javax.servlet.http.HttpServletResponse;

/**
 * @author 全俊
 */
@Service
public class TbDepartmentServiceImpl extends ServiceImpl<TbDepartmentMapper, TbDepartment> implements TbDepartmentService {

    /**
     * 查询当前所有部门并查询当前部门所有人数
     *
     * @return 查询到的信息
     */
    @Override
    public List<TbDepartmentShowView> getDepartment() {
        return this.baseMapper.getDepartment();
    }

    /**
     * 根据传入条件分页查询
     *
     * @param page    分页信息
     * @param wrapper 查询条件
     * @return 查询结果
     */
    @Override
    public Page<TbDepartmentAndUser> findAll(Page<TbDepartmentAndUser> page, Wrapper<TbDepartmentAndUser> wrapper) {
        Page<TbDepartmentAndUser> pageVO = this.baseMapper.findAll(page, wrapper);
        if (pageVO.getRecords().size() == 0) {
            Long total = page.getTotal();
            Long size = page.getSize();
            page.setCurrent(total % size == 0 ? total / size : total / size + 1);
            pageVO = this.baseMapper.findAll(page, wrapper);
        }
        return pageVO;
    }

    /**
     * 获取是否有当前传入name的部门
     *
     * @param name 部门名
     * @return 查询到的格式
     */
    @Override
    public Integer selectCount(String name) {
        return this.baseMapper.count(name);
    }

    /**
     * 导出查询到的部门信息为excel
     *
     * @param response 用于导出excel
     * @param wrapper  导出条件
     */
    @Override
    public void findListExcel(HttpServletResponse response, Wrapper<TbDepartmentExcel> wrapper) {
        List<TbDepartmentExcel> list = this.baseMapper.findListExcel(wrapper);
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = null;
        try {
            fileName = URLEncoder.encode("部门信息表", "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        try {
            EasyExcel.write(response.getOutputStream(), TbDepartmentExcel.class).sheet("模板").doWrite(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


