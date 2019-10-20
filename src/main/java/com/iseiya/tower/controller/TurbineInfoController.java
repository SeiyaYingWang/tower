package com.iseiya.tower.controller;

import com.iseiya.tower.entity.TurbineInfo;
import com.iseiya.tower.service.TurbineInfoService;
import com.iseiya.tower.util.ResultVOUtil;
import com.iseiya.tower.vo.ResultVO;
import com.iseiya.tower.vo.TurbineVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@Slf4j
public class TurbineInfoController {

    @Autowired
    private TurbineInfoService turbineInfoService;

//    @GetMapping("/findTurbineInfoById")
//    public ResultVO<TurbineInfo> findTurbineInfoById(@RequestParam("turbineId") String turbineId){
//        TurbineInfo turbineInfo =  turbineInfoService.findTurbineInfoById(turbineId);
//
//        List<TurbineInfo> list = new ArrayList<TurbineInfo>();
//        list.add(turbineInfo);
//        list.add(turbineInfo);
//        list.add(turbineInfo);
//        list.add(turbineInfo);
//
//        OpenCsvHandler<TurbineInfo> handler = new OpenCsvHandler<TurbineInfo>();
//        String[] header= {"id","winfarmId","turbineId","turbineName","ip"};
//        String[] columnMapping = {"id","winfarmId","turbineId","turbineName","ip"};
//        // 写表头
//        handler.writeCSVHeader("C:\\ensightwindconf\\storage\\test\\test.dat",header );
//        handler.writeCSVData(list, "C:\\ensightwindconf\\storage\\test\\test.dat",TurbineInfo.class, columnMapping );
//        // turbineInfoService.keepHeartBeat();
//        return ResultVOUtil.success(turbineInfo);
//    }

    @GetMapping("/list")
    public ResultVO<TurbineVO> findTurbineInfoById(){
        return ResultVOUtil.success(turbineInfoService.list());
    }




    }
