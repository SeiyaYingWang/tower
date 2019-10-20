package com.iseiya.tower.service;

import com.iseiya.tower.entity.TurbineInfo;
import com.iseiya.tower.vo.TurbineVO;

import java.util.List;

public interface TurbineInfoService {

    public TurbineInfo findTurbineInfoById(String id);

    public List<TurbineVO> list();
}
