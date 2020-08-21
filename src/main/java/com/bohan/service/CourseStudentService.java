package com.bohan.service;

import com.bohan.vo.resp.CourseStudentRespVO;

import java.util.List;

public interface CourseStudentService {

    List<CourseStudentRespVO> queryCoursesByStudentId(String id);

    void registerCourse(String studentId, String CourseId);

    int checkIfStudentValid(String studentId,String courseId);
}
