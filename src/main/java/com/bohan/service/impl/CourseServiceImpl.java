package com.bohan.service.impl;


import com.bohan.entity.Course;
import com.bohan.mapper.CourseMapper;
import com.bohan.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {


    @Autowired
    CourseMapper courseMapper;

    @Override
    public List<Course> queryAll() {

        return courseMapper.queryAll();
    }
}
