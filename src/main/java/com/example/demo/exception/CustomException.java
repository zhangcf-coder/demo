package com.example.demo.exception;

public class CustomException extends Exception {

    private static final long serialVersionUID = 5819174480253773214L;

    // 异常信息
    private String message;

    public CustomException(String message) {
        super(message);
        this.message = message;

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
