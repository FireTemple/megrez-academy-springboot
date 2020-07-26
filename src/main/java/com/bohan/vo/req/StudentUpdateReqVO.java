package com.bohan.vo.req;


import lombok.Data;

@Data
public class StudentUpdateReqVO {

    private String id;
    private String lastName;
    private String firstName;
    private String birth;
    private String gender;
    private String email;
}
