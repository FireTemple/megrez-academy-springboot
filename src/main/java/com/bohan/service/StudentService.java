package com.bohan.service;

import com.bohan.entity.Student;
import com.bohan.vo.req.StudentAddReqVO;

import java.util.List;

public interface StudentService {

    List<Student> queryStudentByUserId(String userId);

    void addStudent(StudentAddReqVO vo);
}
