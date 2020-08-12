package com.quan.service.impl;

import com.quan.vo.BizProductRecursion;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quan.mapper.BizProductCategoryMapper;
import com.quan.pojo.BizProductCategory;
import com.quan.service.BizProductCategoryService;

import java.util.List;

/**
 * @author 全俊
 */
@Service
public class BizProductCategoryServiceImpl extends ServiceImpl<BizProductCategoryMapper, BizProductCategory> implements BizProductCategoryService{

    /**
     * 所有分类信息
     *
     * @return java.util.List
     * @description TODO
     * @methodName findCategory
     * @author 全俊
     * @date 2020/8/12 18:24
     */
    @Override
    public List<BizProductRecursion> findCategory() {
        return this.baseMapper.findCategory(0L);
    }
}
