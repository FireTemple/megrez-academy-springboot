package com.bohan.mapper;

import com.bohan.entity.Course;
import com.bohan.vo.req.CourseAddReqVO;
import com.bohan.vo.resp.CourseBaseInfo;

import java.util.List;

public interface CourseMapper {

    List<Course> queryAll();

    //其实可以删除
    List<CourseBaseInfo> queryBaseInfo();

    int insertSelective(Course course);


}
