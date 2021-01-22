package com.bohan.controller;

import com.bohan.entity.Course;
import com.bohan.service.impl.CourseServiceImpl;
import com.bohan.service.impl.CourseStudentServiceImpl;
import com.bohan.utils.PageUtil;
import com.bohan.utils.ResultData;
import com.bohan.vo.req.CourseAddReqVO;
import com.bohan.vo.req.CourseUpdateReqVO;
import com.bohan.vo.req.PageReqVO;
import com.github.pagehelper.PageHelper;
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

    @Autowired
    CourseStudentServiceImpl courseStudentService;

    @PostMapping("/courses")
    @ApiOperation(value = "query all course")
    public ResultData queryAll(@RequestBody PageReqVO pageReqVO){
        ResultData result = ResultData.success();
        PageHelper.startPage(pageReqVO.getPageNum(), pageReqVO.getPageSize());
        result.setData(PageUtil.getPageVO(courseService.queryAll(pageReqVO)));
        return result;
    }

    @GetMapping("/courses/baseInfo")
    @ApiOperation(value = "query basic information for register")
    public ResultData queryBaseInfo(@RequestBody PageReqVO pageReqVO){
        ResultData result = ResultData.success();
        PageHelper.startPage(pageReqVO.getPageNum(), pageReqVO.getPageSize());
        result.setData(PageUtil.getPageVO(courseService.queryAll(pageReqVO)));
        return result;
    }

    @PostMapping("/course")
    @ApiOperation(value = "add new course")
    public ResultData addCourse(@RequestBody CourseAddReqVO courseAddReqVO){
        System.out.println(courseAddReqVO.getTId());
        ResultData resultData = ResultData.success();
        courseService.addNewCourse(courseAddReqVO);
        return resultData;
    }

    @GetMapping("/course/{id}")
    @ApiOperation(value = "query course by course id")
    public ResultData queryCourseById(@PathVariable("id") String id){
        ResultData resultData = ResultData.success();
        resultData.setData(courseService.queryById(id));
        return resultData;
    }



    @PutMapping("/course")
    @ApiOperation(value = "update course from admin")
    public ResultData updateCourseFromAdmin(@RequestBody Course vo){
        ResultData resultData = ResultData.success();
        courseService.updateCourse(vo);
        return resultData;
    }

    @GetMapping("/course/delete/{id}")
    @ApiOperation(value = "delete course by admin")
    public ResultData deleteCourseFromAdmin(@PathVariable("id")String id){
        ResultData resultData = ResultData.success();
        courseService.deleteCourse(id);
        return resultData;
    }

    @GetMapping("/coursesAdmin")
    @ApiOperation(value = "query course by admin")
    public ResultData queryAllByAdmin(){
        ResultData resultData = ResultData.success();
        resultData.setData(courseService.queryAllByAdmin());
        return resultData;
    }

    @GetMapping("/current/courses")
    @ApiOperation(value = "query current courses")
    public ResultData queryCurrentCourses(){
        ResultData resultData = ResultData.success();
        resultData.setData(courseService.queryCurrentCourse());
        return resultData;
    }

    @GetMapping("/course/start/{id}")
    @ApiOperation(value = "start a course")
    public ResultData startCourseById(@PathVariable("id") String id){
        ResultData result = ResultData.success();
        courseService.startCourse(id);
        return  result;
    }
}
