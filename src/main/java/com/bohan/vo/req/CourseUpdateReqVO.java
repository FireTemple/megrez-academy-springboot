package com.bohan.vo.req;

import lombok.Data;

@Data
public class CourseUpdateReqVO {

    private String id;
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
    private String tId;
}
