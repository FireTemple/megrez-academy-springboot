package com.bohan.service;

import com.bohan.entity.Course;
import com.bohan.vo.req.CourseAddReqVO;
import com.bohan.vo.req.CourseUpdateReqVO;
import com.bohan.vo.resp.CourseBaseInfo;
import com.bohan.vo.resp.CoursesAdminQueryRespVO;

import java.util.List;

public interface CourseService {

    List<Course> queryAll();

    void addNewCourse(CourseAddReqVO vo);

    void deleteCourse(String id);


    void updateCourse(Course course);

    List<CoursesAdminQueryRespVO> queryAllByAdmin();

    CoursesAdminQueryRespVO queryById(String id);
}
