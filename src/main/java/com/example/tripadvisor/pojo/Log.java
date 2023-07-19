package com.example.tripadvisor.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Log {
    private String url;
    private Date visitTime;
    private String username;
    private String ip;
    private int executionTime;
    private String exceptionMessage;
}
