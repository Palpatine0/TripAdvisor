package com.example.tripadvisor.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result {
    private boolean flag;
    private String message;
    private Object data;
    public Result(boolean flag, String message) {
        this(flag,message,null);
    }
}
