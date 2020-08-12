package com.quan.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.quan.pojo.BizProduct;
import com.baomidou.mybatisplus.extension.service.IService;
import com.quan.vo.BizProductVO;

/**
 * @author 全俊
 */
public interface BizProductService extends IService<BizProduct> {

    /**
     * 根据传入条件查询所有分页信息
     *
     * @param page 分页信息
     * @param qw 查询条件
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.quan.vo.BizProductVO>
     * @description TODO
     * @methodName findAll
     * @author 全俊
     * @date 2020/8/12 11:40
     */
    Page<BizProductVO> findAll(Page<BizProductVO> page, QueryWrapper<BizProductVO> qw);
}
