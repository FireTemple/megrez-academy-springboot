package com.bohan.mapper;

import com.bohan.entity.Student;
import com.bohan.vo.resp.StudentQueryAllRespVO;

import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(String id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<StudentQueryAllRespVO> queryStudentByUserId(String userId);

    List<Student> queryAll();

    StudentQueryAllRespVO queryMoreInfoByStudentId(String id);
    List<StudentQueryAllRespVO> queryMoreInfoByCourseId(String id);
}