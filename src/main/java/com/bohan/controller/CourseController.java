package com.bohan.controller;

import com.bohan.service.impl.CourseServiceImpl;
import com.bohan.utils.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "Course Controller")
@RequestMapping("/api")
public class CourseController {

    @Autowired
    CourseServiceImpl courseService;

    @GetMapping("/courses")
    @ApiOperation(value = "query all course")
    public ResultData queryAll(){
        ResultData result = ResultData.success();
        result.setData(courseService.queryAll());
        return result;
    }
}
