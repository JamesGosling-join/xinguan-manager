package com.quan.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.quan.pojo.TbUser;
import com.quan.vo.MgrUser;
import com.quan.vo.UserAndDepartmentVO;
import com.quan.vo.UserExcelVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 全俊
 */
@Mapper
public interface TbUserMapper extends BaseMapper<TbUser> {
    /**
     * 查询当前用户是否存在
     *
     * @param username 用户名
     * @return 不存在返回0
     */
    Integer count(@Param("username") String username);

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
     * @param wrapper 导出条件
     * @return 返回查询结构
     */
    List<UserExcelVO> findListExcel(@Param(Constants.WRAPPER) Wrapper<UserExcelVO> wrapper);

    /**
     * 查询部门主任信息
     *
     * @return 部门主任信息
     */
    List<MgrUser> findMgrUser();
}