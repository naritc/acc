package com.my.acc.config.exception;

import com.my.acc.config.constants.BusinessError;
import lombok.Getter;

@Getter
public class BusinessException extends Exception {

    private final BusinessError error;

    public BusinessException(BusinessError error) {
        super(error.getCode());
        this.error = error;
    }

    public BusinessException(BusinessError error, Throwable cause) {
        super(error.getCode(), cause);
        this.error = error;
    }

}
