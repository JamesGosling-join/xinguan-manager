package com.quan.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.quan.pojo.TbDepartment;
import com.quan.vo.TbDepartmentAndUser;
import com.quan.vo.TbDepartmentExcel;
import com.quan.vo.TbDepartmentShowView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 全俊
 */
@Mapper
public interface TbDepartmentMapper extends BaseMapper<TbDepartment> {
    /**
     * 查询当前所有部门并查询当前部门所有人数
     *
     * @return 查询到的信息
     */
    List<TbDepartmentShowView> getDepartment();

    /**
     * 根据传入条件分页查询
     *
     * @param page    分页信息
     * @param wrapper 查询条件
     * @return 查询结果
     */
    Page<TbDepartmentAndUser> findAll(Page<TbDepartmentAndUser> page, @Param(Constants.WRAPPER) Wrapper<TbDepartmentAndUser> wrapper);

    /**
     * 根据传入部门名查询部门数
     *
     * @param name 部门名
     * @return 部门数量
     */
    Integer count(@Param("name") String name);

    /**
     * 导出查询到的部门信息为excel
     *
     * @param wrapper 导出条件
     * @return 返回查询结构
     */
    List<TbDepartmentExcel> findListExcel(@Param(Constants.WRAPPER) Wrapper<TbDepartmentExcel> wrapper);
}