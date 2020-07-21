package com.bohan.service;

import com.bohan.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> queryStudentByUserId(String userId);
}
