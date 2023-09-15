package com.example.mymonitorbackend.bean;

import lombok.Data;

@Data
public class ApiResult {
    private String message;
    private Object data;
    private int code;
    private String status;
}
