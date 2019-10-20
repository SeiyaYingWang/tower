package com.iseiya.tower.service.impl;

import com.alibaba.fastjson.JSONObject;

import com.iseiya.tower.entity.TurbineInfo;
import com.iseiya.tower.repository.TurbineInfoRepository;
import com.iseiya.tower.service.TurbineInfoService;

import com.iseiya.tower.vo.TurbineVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;


/**
 * @author seiya.y.wang
 * */
@Service
@Slf4j
public class TurbineInfoServiceImpl implements TurbineInfoService {
    @Autowired
    private TurbineInfoRepository turbineInfoRepository;

    public TurbineInfo findTurbineInfoById(String turbineId){
        TurbineInfo turbineInfo = turbineInfoRepository.findByTurbineId(turbineId);
        return turbineInfo;
    }

    @Cacheable(cacheNames = "turbine",key="123")
    public List<TurbineVO> list() {
        List<TurbineInfo> turbineInfos = turbineInfoRepository.findAll();
        List<TurbineVO> turbineVOS = turbineInfos.stream().map(temp -> {
            TurbineVO turbineVO = new TurbineVO();
            BeanUtils.copyProperties(temp, turbineVO);
            return turbineVO;
        }).collect(Collectors.toList());
        log.info("in list");
        return turbineVOS;
    }



}
