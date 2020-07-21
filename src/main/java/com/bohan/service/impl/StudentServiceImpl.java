package com.bohan.service.impl;

import com.bohan.entity.Student;
import com.bohan.mapper.StudentMapper;
import com.bohan.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {


    @Autowired
    StudentMapper studentMapper;

    @Override
    public List<Student> queryStudentByUserId(String userId) {
        return studentMapper.queryStudentsByUserId(userId);
    }
}
