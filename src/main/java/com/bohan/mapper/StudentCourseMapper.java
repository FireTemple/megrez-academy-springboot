package com.bohan.mapper;

import com.bohan.entity.StudentCourse;

public interface StudentCourseMapper {
    int deleteByPrimaryKey(String id);

    int insert(StudentCourse record);

    int insertSelective(StudentCourse record);

    StudentCourse selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(StudentCourse record);

    int updateByPrimaryKey(StudentCourse record);

    StudentCourse findRecord(String studentId, String courseId);
}