package com.iseiya.tower.exception;

import com.iseiya.tower.enums.ResultEnum;

public class TowerException extends RuntimeException{

    private Integer code;

    public TowerException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public TowerException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
