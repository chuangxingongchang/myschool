package com.school.entity;

import lombok.Data;

@Data
public class Message {
    private boolean status;
    private String msg;
    private Object data;
}
