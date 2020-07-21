package com.bohan.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Student {

    private String id;
    private String firstName;
    private String lastName;
    private String birth;
    private Integer gender;
    private Timestamp createTime;
}
