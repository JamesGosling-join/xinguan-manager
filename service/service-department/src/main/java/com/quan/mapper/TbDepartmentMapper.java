package com.quan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.quan.pojo.TbDepartment;
import com.quan.vo.TbDepartmentShowView;
import org.apache.ibatis.annotations.Mapper;

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
}