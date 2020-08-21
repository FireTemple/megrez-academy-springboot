package com.bohan.service.impl;

import com.bohan.entity.Professor;
import com.bohan.exception.BaseResponseCode;
import com.bohan.exception.BaseResponseCodeImp;
import com.bohan.exception.BusinessExceptionIpm;
import com.bohan.mapper.ProfessorMapper;
import com.bohan.service.ProfessorService;
import com.bohan.vo.resp.CourseProfessorRespVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    ProfessorMapper professorMapper;



    @Override
    public Professor queryById(String id) {
        return professorMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateProfessor(Professor professor) {

        int i = professorMapper.updateByPrimaryKeySelective(professor);
        if (i != 1) {
            throw new BusinessExceptionIpm(BaseResponseCodeImp.DATABASE_ERROR_UPDATE);
        }

    }

    @Override
    public void deleteProfessor(String id) {

        int i = professorMapper.deleteByPrimaryKey(id);
        if (i != 1){
            throw new BusinessExceptionIpm(BaseResponseCodeImp.DATABASE_ERROR_DELETE);
        }
    }

    @Override
    public void addProfessor(Professor professor) {
        professor.setId(UUID.randomUUID().toString());

        int i = professorMapper.insertSelective(professor);
        if (i != 1){
            throw new BusinessExceptionIpm(BaseResponseCodeImp.DATABASE_ERROR_INSERT);
        }
    }

    @Override
    public List<Professor> queryAll() {
        return professorMapper.queryAll();
    }
}
