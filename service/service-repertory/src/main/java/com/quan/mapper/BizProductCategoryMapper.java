package com.quan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.quan.pojo.BizProductCategory;
import com.quan.vo.BizProductRecursion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 全俊
 */
@Mapper
public interface BizProductCategoryMapper extends BaseMapper<BizProductCategory> {
    /**
     * 所有分类信息
     *
     * @param pid 父级id
     * @return java.util.List
     * @description TODO
     * @methodName findCategory
     * @author 全俊
     * @date 2020/8/12 18:24
     */
    List<BizProductRecursion> findCategory(@Param("pid") Long pid);
}