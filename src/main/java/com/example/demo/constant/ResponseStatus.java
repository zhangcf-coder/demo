package com.example.demo.constant;

import java.io.Serializable;

public enum ResponseStatus implements Serializable {
    SUCCESS("OK", "成功"),
    NEEDLOGIN("NeedLogin", "无Session内容"),
    FAIL("FAIL", "失败"),
    HALF_OK("Half_OK", "部分成功"),
    NO_PERMISSION("NoPermission", "没有权限");


    private String code;

    private String value;

    ResponseStatus(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
