package com.quan.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.quan.service.TbUserService;
import com.quan.vo.MgrUser;
import com.quan.vo.UserAndDepartmentVO;
import com.quan.vo.UserExcelVO;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quan.pojo.TbUser;
import com.quan.mapper.TbUserMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author 全俊
 */
@Service
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser> implements TbUserService {
    /**
     * 根据用户名查询用户是否存在
     *
     * @param wrapper 查询条件
     * @return 查询结果
     */
    @Override
    public Integer selectCount(Wrapper<TbUser> wrapper) {
        return this.baseMapper.count(wrapper);
    }

    /**
     * 根据传入条件查询所有并分页
     *
     * @param page    分页信息
     * @param wrapper 查询条件
     * @return 得到的信息
     */
    @Override
    public Page<UserAndDepartmentVO> findAll(Page<UserAndDepartmentVO> page, Wrapper<UserAndDepartmentVO> wrapper) {
        Page<UserAndDepartmentVO> voPage = this.baseMapper.findAll(page, wrapper);
        if (voPage.getRecords().size() == 0) {
            Long total = page.getTotal();
            Long size = page.getSize();
            page.setCurrent(total % size == 0 ? total / size : total / size + 1);
            voPage = this.baseMapper.findAll(page, wrapper);
        }
        return voPage;
    }

    /**
     * 查询部门主任信息
     *
     * @return 部门主任信息
     */
    @Override
    public List<MgrUser> findMgrUser() {
        return this.baseMapper.findMgrUser();
    }

    /**
     * 导出查询到的用户信息为excel
     *
     * @param response 用于导出excel
     * @param wrapper  导出条件
     */
    @Override
    public void findListExcel(HttpServletResponse response, Wrapper<UserExcelVO> wrapper) {
        List<UserExcelVO> list = this.baseMapper.findListExcel(wrapper);
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = null;
        try {
            fileName = URLEncoder.encode("学生信息表", "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        try {
            EasyExcel.write(response.getOutputStream(), UserExcelVO.class).sheet("模板").doWrite(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}