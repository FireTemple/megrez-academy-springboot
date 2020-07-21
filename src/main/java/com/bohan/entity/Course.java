package com.bohan.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Course {

    private String id;
    private String professorName;
    private String courseName;
    private String session;
    private Timestamp startTime;
    private Timestamp endTime;
    private String tuition;
    private String textbook;
    private String prerequisite;

}
