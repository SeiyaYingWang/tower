package com.iseiya.tower.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class TurbineInfo {

    @Id
    @GeneratedValue
    private Long id;

    private String turbineId;

    private String turbineName;

    private String ip;


}
