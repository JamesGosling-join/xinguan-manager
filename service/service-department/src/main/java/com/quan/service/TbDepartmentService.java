package com.quan.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.quan.pojo.TbDepartment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.quan.vo.TbDepartmentAndUser;
import com.quan.vo.TbDepartmentExcel;
import com.quan.vo.TbDepartmentShowView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author 全俊
 */
public interface TbDepartmentService extends IService<TbDepartment> {
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
    Page<TbDepartmentAndUser> findAll(Page<TbDepartmentAndUser> page, Wrapper<TbDepartmentAndUser> wrapper);

    /**
     * 获取是否有当前传入name的部门
     *
     * @param name 部门名
     * @return 查询到的格式
     */
    Integer selectCount(String name);

    /**
     * 导出查询到的部门信息为excel
     *
     * @param response 用于导出excel
     * @param wrapper  导出条件
     */
    void findListExcel(HttpServletResponse response, Wrapper<TbDepartmentExcel> wrapper);
}


