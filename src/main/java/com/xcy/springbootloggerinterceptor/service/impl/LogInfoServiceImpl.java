package com.xcy.springbootloggerinterceptor.service.impl;

import com.xcy.springbootloggerinterceptor.mapper.LogInfoMapper;
import com.xcy.springbootloggerinterceptor.model.LogInfo;
import com.xcy.springbootloggerinterceptor.service.LogInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xcy
 * @date 2018/12/04 15:22
 * @description LogInfoServiceImpl
 * @since V1.0.0
 */
@Service("logInfoService")
public class LogInfoServiceImpl implements LogInfoService {

    @Autowired
    private LogInfoMapper logInfoMapper;

    @Override
    public void insertLog(LogInfo logInfo) {
        logInfoMapper.insert(logInfo);
    }
}
