package com.bohan.controller;

import com.bohan.service.impl.CourseServiceImpl;
import com.bohan.utils.ResultData;
import com.bohan.vo.req.CourseAddReqVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/courses/baseInfo")
    @ApiOperation(value = "query basic information for register")
    public ResultData queryBaseInfo(){
        ResultData result = ResultData.success();
        result.setData(courseService.queryBaseInfo());
        return result;
    }

    @PostMapping("/course")
    @ApiOperation(value = "add new course")
    public ResultData addCourse(@RequestBody CourseAddReqVO courseAddReqVO){
        ResultData resultData = ResultData.success();
        courseService.addNewCourse(courseAddReqVO);
        return resultData;
    }
}
