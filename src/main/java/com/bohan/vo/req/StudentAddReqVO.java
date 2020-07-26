package com.bohan.vo.req;

import lombok.Data;

@Data
public class StudentAddReqVO {

    private String firstName;
    private String lastName;
    private String birth;
    private String gender;
    private String email;
    private String pId;
}
