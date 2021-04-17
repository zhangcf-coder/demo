package com.example.demo.vo;


import com.example.demo.constant.ResponseStatus;
import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseResult implements Serializable {
    // 响应业务状态
    private String status;

    // 响应消息
    private String message;

    // 响应中的数据
    private Object data;
    public ResponseResult(Object data) {
        this.status = ResponseStatus.SUCCESS.getCode();
        this.message = "success";
        this.data = data;
    }
}
