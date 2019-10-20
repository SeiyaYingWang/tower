package com.iseiya.tower.enums;

import lombok.Getter;


@Getter
public enum ResultEnum {

    DATA_NOT_EXIST(1, "配置数据没有找到"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
