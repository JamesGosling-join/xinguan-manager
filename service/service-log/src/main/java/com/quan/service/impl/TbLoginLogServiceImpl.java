package com.quan.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quan.mapper.TbLoginLogMapper;
import com.quan.pojo.TbLoginLog;
import com.quan.service.TbLoginLogService;
/**
 * @author 全俊
 */
@Service
public class TbLoginLogServiceImpl extends ServiceImpl<TbLoginLogMapper, TbLoginLog> implements TbLoginLogService{
}
