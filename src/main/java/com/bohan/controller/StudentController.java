package com.bohan.controller;

import com.bohan.service.impl.StudentServiceImpl;
import com.bohan.utils.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
@Api(tags = "student controller")
public class StudentController {

    @Autowired
    StudentServiceImpl studentService;


    @GetMapping("/students/{userId}")
    @ApiOperation(value = "query parent's kids")
    public ResultData queryStudentsByUserId(@PathVariable("userId") String userId){
        ResultData result = ResultData.success();
        result.setData(studentService.queryStudentByUserId(userId));
        return result;
    }

}
