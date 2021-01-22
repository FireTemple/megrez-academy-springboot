package com.bohan.vo.resp;

import lombok.Data;

@Data
public class StudentQueryAllRespVO {

    private String id;
    private String firstName;
    private String lastName;
    private String birth;
    private String gender;
    private String status;
    private String currentGrade;
    private String currentSchool;
    private String pUsername;
    private String pName;
}
