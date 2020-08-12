package com.quan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.quan.vo.BizProductVO;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quan.mapper.BizProductMapper;
import com.quan.pojo.BizProduct;
import com.quan.service.BizProductService;
/**
 * @author 全俊
 */
@Service
public class BizProductServiceImpl extends ServiceImpl<BizProductMapper, BizProduct> implements BizProductService{

    /**
     * 根据传入条件查询所有分页信息
     *
     * @param page 分页信息
     * @param qw   查询条件
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.quan.vo.BizProductVO>
     * @description TODO
     * @methodName findAll
     * @author 全俊
     * @date 2020/8/12 11:40
     */
    @Override
    public Page<BizProductVO> findAll(Page<BizProductVO> page, QueryWrapper<BizProductVO> qw) {
        return this.baseMapper.findAll(page,qw);
    }
}
