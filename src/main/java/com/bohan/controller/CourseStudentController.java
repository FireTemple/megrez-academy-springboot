package com.bohan.controller;

import com.bohan.service.impl.CourseStudentServiceImpl;
import com.bohan.utils.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Api(tags = "course and student related query and operation")
public class CourseStudentController {

    @Autowired
    CourseStudentServiceImpl courseStudentService;

    @PostMapping("/check")
    @ApiOperation("check if student is valid for register this course")
    public ResultData checkStatus(String studentId,String courseId){
        ResultData result = ResultData.success();
        int i = courseStudentService.checkIfStudentValid(studentId, courseId);
        result.setData(i);
        return result;
    }

    @GetMapping("/current/students/{courseId}")
    @ApiOperation(value = "find all students for this course")
    public ResultData queryCurrentStudentByCourseId(@PathVariable("courseId")String id){
        ResultData resultData = ResultData.success();
        resultData.setData(courseStudentService.queryAllByCourseId(id));
        return resultData;
    }

}
