package com.quan.service.impl;

import com.quan.vo.TbDepartmentShowView;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quan.mapper.TbDepartmentMapper;
import com.quan.pojo.TbDepartment;
import com.quan.service.TbDepartmentService;

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
}


