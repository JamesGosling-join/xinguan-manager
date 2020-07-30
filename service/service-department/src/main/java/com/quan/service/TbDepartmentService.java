package com.quan.service;

import com.quan.pojo.TbDepartment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.quan.vo.TbDepartmentShowView;

import java.util.List;

/**
 * @author 全俊
 */
public interface TbDepartmentService extends IService<TbDepartment> {
    /**
     * 查询当前所有部门并查询当前部门所有人数
     * @return 查询到的信息
     */
    List<TbDepartmentShowView> getDepartment();
}


