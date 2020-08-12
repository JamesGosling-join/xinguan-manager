package com.quan.service;

import com.quan.pojo.BizProductCategory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.quan.vo.BizProductRecursion;

import java.util.List;

/**
 * @author 全俊
 */
public interface BizProductCategoryService extends IService<BizProductCategory> {

    /**
     * 所有分类信息
     *
     * @return java.util.List
     * @description TODO
     * @methodName findCategory
     * @author 全俊
     * @date 2020/8/12 18:24
     */
    List<BizProductRecursion> findCategory();
}
