package com.iseiya.tower.repository;

import com.iseiya.tower.entity.TurbineInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurbineInfoRepository extends JpaRepository<TurbineInfo, String> {

    public TurbineInfo findByTurbineId(String turbineId);
}
