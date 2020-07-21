package com.bohan.service.impl;

import com.bohan.mapper.ProfessorMapper;
import com.bohan.service.ProfessorService;
import com.bohan.vo.resp.CourseProfessorRespVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    ProfessorMapper professorMapper;

    @Override
    public List<CourseProfessorRespVO> queryAllProfessorName() {
        return professorMapper.queryAllProfessorName();
    }
}
