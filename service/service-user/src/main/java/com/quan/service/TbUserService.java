package com.quan.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.quan.pojo.TbUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.quan.vo.MgrUser;
import com.quan.vo.UserAndDepartmentVO;
import com.quan.vo.UserExcelVO;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
     * @param wrapper  导出条件
     */
    void findListExcel(HttpServletResponse response, Wrapper<UserExcelVO> wrapper);

    /**
     * 查询部门主任信息
     *
     * @return 部门主任信息
     */
    List<MgrUser> findMgrUser();

    /**
     * @param avatar   头像地址
     * @param username 用户名
     * @return java.lang.Boolean
     * @description TODO
     * @methodName updateByName
     * @author 全俊
     * @date 2020/8/2 23:02
     */
    Boolean updateByName(String avatar, String username);
}
