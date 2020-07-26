package com.bohan.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Course {

    private String id;
    private String professorName;
    private String name;
    private String session;
    private String startTime;
    private String endTime;
    private String tuition;
    private String textbook;
    private String prerequisiteId;
    private String des;
    private String tId;
    private String prerequisiteName;
    private String passed;
}
