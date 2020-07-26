package com.bohan.vo.req;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class CourseAddReqVO {

    private String name;
    private String startTime;
    private String endTime;
    private String session;
    private String tId;
    private String prerequisiteId;
    private String tuition;
    private String textbook;
    private String des;

}
