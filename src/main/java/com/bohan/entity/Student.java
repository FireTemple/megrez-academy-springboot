package com.bohan.entity;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class Student {

    private String id;
    private String firstName;
    private String lastName;
    private String birth;
    private Integer gender;
    private Date createTime;
    private String pId;
    private String email;
}
