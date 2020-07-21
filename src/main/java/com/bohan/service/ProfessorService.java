package com.bohan.service;

import com.bohan.vo.resp.CourseProfessorRespVO;

import java.util.List;

public interface ProfessorService {

    List<CourseProfessorRespVO> queryAllProfessorName();
}
