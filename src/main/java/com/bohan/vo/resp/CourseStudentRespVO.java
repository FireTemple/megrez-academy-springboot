package com.bohan.vo.resp;

import lombok.Data;

@Data
public class CourseStudentRespVO {

    private String id;
    private String name;
    private String session;
    private String startTime;
    private String endTime;
    private String textbook;
    private String des;
    private String passed;

}
