package com.bohan.entity;

import lombok.Data;

import java.util.Date;


@Data
public class User {


    private String id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private String address;
    private Date createTime;

}
