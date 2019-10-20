package com.iseiya.tower.vo;

import lombok.Data;

/**
 * 用于写入CSV的Bean
 * */
@Data
public class TowerBaseDataVO {

    private String id;

    private String winfarm_code;

    private String turbine_code;

    private String slope;

    private String filter;

    private String slope_x;

    private String slope_y;

    private String slope_z;

    private String raw_x;

    private String raw_y;

    private String raw_z;

    private String total;

    private String temp;

    private String settlement;

    private String slope_direction;

    private String timestamps;

    private String datastatus;
}
