package com.bohan.service.impl;


import com.bohan.entity.Course;
import com.bohan.exception.BaseResponseCode;
import com.bohan.exception.BaseResponseCodeImp;
import com.bohan.exception.BusinessExceptionIpm;
import com.bohan.mapper.CourseMapper;
import com.bohan.service.CourseService;
import com.bohan.vo.req.CourseAddReqVO;
import com.bohan.vo.resp.CourseBaseInfo;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CourseServiceImpl implements CourseService {


    @Autowired
    CourseMapper courseMapper;

    @Override
    public List<Course> queryAll() {

        return courseMapper.queryAll();
    }

    @Override
    public List<CourseBaseInfo> queryBaseInfo() {
        return courseMapper.queryBaseInfo();
    }


    @Override
    public void addNewCourse(CourseAddReqVO vo) {
        Course course = new Course();
        BeanUtils.copyProperties(vo, course);
        course.setId(UUID.randomUUID().toString());
        course.setPassed("1");
        int i = courseMapper.insertSelective(course);
        if (i != 1){
            throw new BusinessExceptionIpm(BaseResponseCodeImp.DATABASE_ERROR_INSERT);
        }
    }
}
