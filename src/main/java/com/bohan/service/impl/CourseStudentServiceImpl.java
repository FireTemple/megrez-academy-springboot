package com.bohan.service.impl;

import com.bohan.entity.StudentCourse;
import com.bohan.exception.BaseResponseCodeImp;
import com.bohan.exception.BusinessExceptionIpm;
import com.bohan.mapper.StudentCourseMapper;
import com.bohan.service.CourseStudentService;
import com.bohan.vo.resp.CourseStudentRespVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CourseStudentServiceImpl implements CourseStudentService {

    @Autowired
    StudentCourseMapper studentCourseMapper;

    @Override
    public List<CourseStudentRespVO> queryCoursesByStudentId(String id) {

        return null;
    }

    @Override
    public void registerCourse(String studentId, String courseId) {
        StudentCourse studentCourse = new StudentCourse();
        studentCourse.setId(UUID.randomUUID().toString());

        studentCourse.setcId(courseId);
        studentCourse.setsId(studentId);

        int i = studentCourseMapper.insert(studentCourse);
        if (i != 1){
            throw new BusinessExceptionIpm(BaseResponseCodeImp.DATABASE_ERROR_INSERT);
        }
    }

    @Override
    public int checkIfStudentValid(String studentId, String courseId) {

        if (studentId == null || courseId == null){
            throw new BusinessExceptionIpm(BaseResponseCodeImp.DATA_MISSING);
        }

        StudentCourse record = studentCourseMapper.findRecord(studentId, courseId);
        // 0: valid 1:invalid
        if (record != null) return 1;
        else return 0;
    }
}
