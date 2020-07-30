package com.quan.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.quan.pojo.TbUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.quan.vo.UserAndDepartmentVO;
import com.quan.vo.UserExcelVO;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletResponse;

/**
 * @author 全俊
 */
public interface TbUserService extends IService<TbUser> {
    /**
     * 根据用户名查询用户是否存在
     *
     * @param username 用户名
     * @return 查询结果
     */
    Integer selectCount(String username);

    /**
     * 根据传入条件查询所有并分页
     *
     * @param page    分页信息
     * @param wrapper 查询条件
     * @return 得到的信息
     */
    Page<UserAndDepartmentVO> findAll(Page<UserAndDepartmentVO> page, @Param(Constants.WRAPPER) Wrapper<UserAndDepartmentVO> wrapper);

    /**
     * 导出查询到的用户信息为excel
     *
     * @param response 用于导出excel
     * @param qw 导出条件
     */
    void findListExcel(HttpServletResponse response, Wrapper<UserExcelVO> qw);
}
