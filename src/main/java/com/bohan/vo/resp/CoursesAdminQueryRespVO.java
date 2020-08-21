package com.bohan.vo.resp;

import lombok.Data;

import java.sql.Date;


@Data
public class CoursesAdminQueryRespVO {

    private String id;
    private String tId;
    private String name;
    private String session;
    private String startTime;
    private String endTime;
    private String tuition;
    private String textbook;
    private String prerequisite;
    private String des;
    private String status;
    private String semester;
    private String number;
    private String lastName;
    private String firstName;
}
