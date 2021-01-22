package com.bohan.controller;

import com.bohan.exception.BaseResponseCode;
import com.bohan.exception.BaseResponseCodeImp;
import com.bohan.service.impl.StudentServiceImpl;
import com.bohan.utils.ResultData;
import com.bohan.vo.req.StudentAddReqVO;
import com.bohan.vo.req.StudentUpdateReqVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


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

    @PostMapping("/student")
    @ApiOperation(value = "add new student")
    public ResultData addNewStudent(@RequestBody StudentAddReqVO vo){
        System.out.println(vo.getpId());
        studentService.addStudent(vo);
        return ResultData.success();
    }

    @DeleteMapping("/student/{id}")
    @ApiOperation(value = "delete student")
    public ResultData deleteStudentsByUserId(@PathVariable("id") String id){
        ResultData result = ResultData.success();
        studentService.deleteStudent(id);
        return result;
    }


    @PutMapping("/student")
    @ApiOperation(value = "updating student information")
    public ResultData updateStudent(@RequestBody StudentUpdateReqVO vo){
        ResultData resultData = ResultData.success();
        studentService.updateStudentById(vo);
        return resultData;
    }

    @GetMapping("/students")
    @ApiOperation(value = "query All Students by admin")
    public ResultData queryAll(){
        ResultData resultData = ResultData.success();
        resultData.setData(studentService.queryAll());
        return resultData;
    }

    @GetMapping("/student/{studentId}")
    @ApiOperation(value = "query student by id")
    public ResultData queryStudentByStudentId(@PathVariable("studentId") String studentId){
        ResultData result = ResultData.success();
        result.setData(studentService.queryStudentById(studentId));
        return result;
    }

    @GetMapping("/students/course/{courseId}")
    @ApiOperation(value = "query students by course id")
    public ResultData queryStudentByCourseId(@PathVariable("courseId")String courseId){
        ResultData result = ResultData.success();
        result.setData(studentService.queryStudentByCourseId(courseId));
        return result;
    }
}
