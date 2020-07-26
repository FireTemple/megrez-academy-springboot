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

    @PostMapping("/student/add")
    @ApiOperation(value = "add new student")
    public ResultData addNewStudent(@RequestBody StudentAddReqVO vo, HttpServletRequest request){
        String pId = request.getHeader("userId");
        if (pId == null){
            return new ResultData(100000,"you need login first");
        }
        vo.setPId(pId);
        studentService.addStudent(vo);
        return ResultData.success();
    }

    @DeleteMapping("/students/{id}")
    @ApiOperation(value = "query parent's kids")
    public ResultData deleteStudentsByUserId(@PathVariable("id") String id){
        ResultData result = ResultData.success();
        studentService.deleteStudent(id);
        return result;
    }


    @PostMapping("/student")
    @ApiOperation(value = "updating student information")
    public ResultData updateStudent(@RequestBody StudentUpdateReqVO vo,HttpServletRequest request){
        ResultData resultData = ResultData.success();
        vo.setId(request.getHeader("studentId"));
        System.out.println("id in controller:  "+ vo.getId());
        studentService.updateStudentById(vo);
        return resultData;
    }

}
