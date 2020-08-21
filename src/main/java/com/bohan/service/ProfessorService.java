package com.bohan.service;

import com.bohan.entity.Professor;
import com.bohan.vo.resp.CourseProfessorRespVO;

import java.util.List;

public interface ProfessorService {

    List<Professor> queryAll();


    Professor queryById(String id);

    void updateProfessor(Professor professor);

    void deleteProfessor(String id);

    void addProfessor(Professor professor);
}
