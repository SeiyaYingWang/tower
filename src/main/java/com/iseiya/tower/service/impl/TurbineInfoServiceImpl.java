package com.iseiya.tower.service.impl;

import com.alibaba.fastjson.JSONObject;

import com.iseiya.tower.entity.TurbineInfo;
import com.iseiya.tower.repository.TurbineInfoRepository;
import com.iseiya.tower.service.TurbineInfoService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


/**
 * @author seiya.y.wang
 *
 * */
@Service
@Slf4j
public class TurbineInfoServiceImpl implements TurbineInfoService {
    @Autowired
    private TurbineInfoRepository turbineInfoRepository;



    // 测试用方法，可忽略
    public TurbineInfo findTurbineInfoById(String turbineId){
        TurbineInfo turbineInfo = turbineInfoRepository.findByTurbineId(turbineId);
        return turbineInfo;
    }



}
