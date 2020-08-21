package com.bohan.service.impl;

import com.bohan.entity.Student;
import com.bohan.exception.BaseResponseCodeImp;
import com.bohan.exception.BusinessExceptionIpm;
import com.bohan.mapper.StudentMapper;
import com.bohan.service.StudentService;
import com.bohan.vo.req.StudentAddReqVO;
import com.bohan.vo.req.StudentUpdateReqVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {


    @Autowired
    StudentMapper studentMapper;

    @Override
    public List<Student> queryStudentByUserId(String userId) {
        return studentMapper.queryStudentByUserId(userId);
    }

    @Override
    public void addStudent(StudentAddReqVO vo) {
        Student student = new Student();
        BeanUtils.copyProperties(vo, student);
        student.setId(UUID.randomUUID().toString());
        student.setCreateTime(new Date());

        int i = studentMapper.insertSelective(student);
        if (i != 1){
            throw new BusinessExceptionIpm(BaseResponseCodeImp.DATABASE_ERROR_INSERT);
        }
    }

    @Override
    public void deleteStudent(String id) {
        int i = studentMapper.deleteByPrimaryKey(id);
        if (i != 1){
            throw new BusinessExceptionIpm(BaseResponseCodeImp.DATABASE_ERROR_DELETE);
        }
    }


    @Override
    public void updateStudentById(StudentUpdateReqVO vo) {
        Student student = new Student();
        BeanUtils.copyProperties(vo, student);
        int i = studentMapper.updateByPrimaryKeySelective(student);
        if (i != 1){
            throw new BusinessExceptionIpm(BaseResponseCodeImp.DATABASE_ERROR_UPDATE);
        }
    }
}
