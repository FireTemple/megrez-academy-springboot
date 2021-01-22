package com.bohan.service.impl;


import com.bohan.entity.Course;
import com.bohan.entity.Student;
import com.bohan.exception.BaseResponseCode;
import com.bohan.exception.BaseResponseCodeImp;
import com.bohan.exception.BusinessExceptionIpm;
import com.bohan.mapper.CourseMapper;
import com.bohan.service.CourseService;
import com.bohan.vo.req.CourseAddReqVO;
import com.bohan.vo.req.CourseUpdateReqVO;
import com.bohan.vo.req.PageReqVO;
import com.bohan.vo.resp.CourseBaseInfo;
import com.bohan.vo.resp.CoursesAdminQueryRespVO;
import com.bohan.vo.resp.PageVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CourseServiceImpl implements CourseService {



    @Autowired
    CourseMapper courseMapper;

    @Override
    public List<Course> queryAll(PageReqVO pageReqVO) {
        return courseMapper.queryAll(pageReqVO);
    }


    @Override
    public void addNewCourse(CourseAddReqVO vo) {
        Course course = new Course();
        BeanUtils.copyProperties(vo, course);

        System.out.println(course.gettId());
        course.setId(UUID.randomUUID().toString());
        int i = courseMapper.insertSelective(course);
        if (i != 1){
            throw new BusinessExceptionIpm(BaseResponseCodeImp.DATABASE_ERROR_INSERT);
        }
    }

    @Override
    public void deleteCourse(String id) {
        int i = courseMapper.deleteByPrimaryKey(id);
        if (i != 1){
            throw new BusinessExceptionIpm(BaseResponseCodeImp.DATABASE_ERROR_UPDATE);
        }
    }

    @Override
    public void updateCourse(Course updateCourse) {
        Course course = new Course();
        BeanUtils.copyProperties(updateCourse, course);

        int i = courseMapper.updateByPrimaryKeySelective(course);
        if (i != 1){
            throw new BusinessExceptionIpm(BaseResponseCodeImp.DATABASE_ERROR_UPDATE);
        }
    }

    @Override
    public List<CoursesAdminQueryRespVO> queryAllByAdmin() {
        return courseMapper.queryAllByAdmin();
    }

    @Override
    public CoursesAdminQueryRespVO queryById(String id) {
        CoursesAdminQueryRespVO coursesAdminQueryRespVO = courseMapper.queryMoreInfoById(id);
        if (coursesAdminQueryRespVO == null){
            throw new BusinessExceptionIpm(BaseResponseCodeImp.DATABASE_ERROR_QUERY_COURSE);
        }
        return coursesAdminQueryRespVO;
    }

    @Override
    public List<CoursesAdminQueryRespVO> queryCurrentCourse() {
        return courseMapper.queryCurrentCourse();
    }

    @Override
    public void startCourse(String id) {
        int i = courseMapper.startCourseByCourseId(id);

        if (i != 1){
            throw new BusinessExceptionIpm(BaseResponseCodeImp.DATABASE_ERROR_UPDATE);
        }

    }
}
