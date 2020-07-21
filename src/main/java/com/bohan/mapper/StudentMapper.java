package com.bohan.mapper;


import com.bohan.entity.Student;

import java.util.List;

public interface StudentMapper {

    List<Student> queryAll();

    List<Student> queryStudentsByUserId(String userId);
}
