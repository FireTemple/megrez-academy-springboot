package com.bohan.mapper;

import com.bohan.entity.StudentCourse;
import com.bohan.vo.resp.StudentQueryAllRespVO;

import java.util.List;

public interface StudentCourseMapper {
    int deleteByPrimaryKey(String id);

    int insert(StudentCourse record);

    int insertSelective(StudentCourse record);

    StudentCourse selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(StudentCourse record);

    int updateByPrimaryKey(StudentCourse record);

    StudentCourse findRecord(String studentId, String courseId);

    List<StudentQueryAllRespVO> findStudentsByCourseId(String courseId);

    List<StudentQueryAllRespVO> queryMoreInfoByCourseId(String id);
}