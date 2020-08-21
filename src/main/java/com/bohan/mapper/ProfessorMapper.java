package com.bohan.mapper;

import com.bohan.entity.Professor;
import com.bohan.vo.resp.CourseProfessorRespVO;

import java.util.List;

public interface ProfessorMapper {
    int deleteByPrimaryKey(String id);

    int insert(Professor record);

    int insertSelective(Professor record);

    Professor selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Professor record);

    int updateByPrimaryKey(Professor record);

    List<Professor> queryAll();

    List<CourseProfessorRespVO> queryAllBasicInfo();
}