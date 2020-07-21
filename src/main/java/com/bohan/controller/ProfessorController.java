package com.bohan.controller;

import com.bohan.service.impl.ProfessorServiceImpl;
import com.bohan.utils.ResultData;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Api(tags = "professor controller")
public class ProfessorController {

    @Autowired
    ProfessorServiceImpl professorService;

    @GetMapping("/professors/name")
    public ResultData queryAllProfessorName(){
        ResultData result = ResultData.success();
        result.setData(professorService.queryAllProfessorName());
        return result;
    }
}
