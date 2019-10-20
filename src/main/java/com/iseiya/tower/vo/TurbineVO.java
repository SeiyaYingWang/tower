package com.iseiya.tower.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class TurbineVO implements Serializable {

    private static final long serialVersionUID = 1507490193115748026L;

    private Long id;

    private String turbineId;

    private String turbineName;

    private String ip;
}
