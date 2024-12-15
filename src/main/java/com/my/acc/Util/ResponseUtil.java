package com.my.acc.Util;

import com.my.acc.config.constants.CommonConstant;
import com.my.acc.model.BaseResponse;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {
    public static ResponseEntity<BaseResponse> success() {
        return ResponseEntity.ok(
                new BaseResponse(CommonConstant.SUCCESS.getCode(), CommonConstant.SUCCESS.getDescription())
        );
    }
}
