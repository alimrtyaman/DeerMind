package com.aliyaman.deermind.handleer;

import lombok.Data;

import java.util.Date;

@Data
public class Exception <E>{

    private String path;

    private String hostName;

    private Date createTime;

    private E message;
}
