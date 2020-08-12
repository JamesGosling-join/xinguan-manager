package com.quan.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.quan.pojo.BizProduct;
import com.quan.vo.BizProductVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 全俊
 */
@Mapper
public interface BizProductMapper extends BaseMapper<BizProduct> {
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
    Page<BizProductVO> findAll(Page<BizProductVO> page, @Param(Constants.WRAPPER) QueryWrapper<BizProductVO> qw);
}