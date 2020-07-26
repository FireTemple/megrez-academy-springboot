package com.bohan.service;

import com.bohan.entity.Course;
import com.bohan.vo.req.CourseAddReqVO;
import com.bohan.vo.resp.CourseBaseInfo;

import java.util.List;

public interface CourseService {

    List<Course> queryAll();

    List<CourseBaseInfo> queryBaseInfo();

    void addNewCourse(CourseAddReqVO vo);
}
