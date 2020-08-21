package com.bohan.mapper;

import com.bohan.entity.Course;
import com.bohan.vo.resp.CoursesAdminQueryRespVO;

import java.util.List;

public interface CourseMapper {
    int deleteByPrimaryKey(String id);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(String id);

    // basic + professor name
    CoursesAdminQueryRespVO queryMoreInfoById(String id);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

    List<Course> queryAll();

    List<CoursesAdminQueryRespVO> queryAllByAdmin();
}