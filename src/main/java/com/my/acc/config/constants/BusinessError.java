package com.my.acc.config.constants;

public enum BusinessError {
    A0001("A0001", "Invalid request"),
    A0002("A0002", "Internal server error"),
    A0003("A0003", "Valid Authentication"),

    E0001("E0001", "Not found url")
    ;

    private final String code;
    private final String description;

    BusinessError(String code, String description) {
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
