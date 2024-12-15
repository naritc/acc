package com.my.acc.config.constants;

public enum CommonConstant {
    SUCCESS("SUCCESS", "Success")
    ;
    private final String code;
    private final String description;

    CommonConstant(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
