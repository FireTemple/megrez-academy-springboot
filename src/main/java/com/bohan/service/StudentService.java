package com.bohan.service;

import com.bohan.entity.Student;
import com.bohan.vo.req.StudentAddReqVO;
import com.bohan.vo.req.StudentUpdateReqVO;
import com.bohan.vo.resp.StudentQueryAllRespVO;

import java.util.List;

public interface StudentService {

    List<StudentQueryAllRespVO> queryStudentByUserId(String userId);

    void addStudent(StudentAddReqVO vo);

    void deleteStudent(String id);

    void updateStudentById(StudentUpdateReqVO vo);

    List<Student> queryAll();

    StudentQueryAllRespVO queryStudentById(String id);
    List<StudentQueryAllRespVO> queryStudentByCourseId(String id);
}
