package com.bohan.mapper;

import com.bohan.vo.resp.CourseProfessorRespVO;

import java.util.List;

public interface ProfessorMapper {

    List<CourseProfessorRespVO> queryAllProfessorName();
}
