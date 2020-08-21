package com.bohan.controller;

import com.bohan.entity.Professor;
import com.bohan.service.impl.ProfessorServiceImpl;
import com.bohan.utils.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Api(tags = "professor controller")
public class ProfessorController {

    @Autowired
    ProfessorServiceImpl professorService;

    @GetMapping("/professors")
    @ApiOperation(value = "query all professor info")
    public ResultData queryAllProfessor(){
        ResultData result = ResultData.success();
        result.setData(professorService.queryAll());
        return result;
    }
    @GetMapping("/professor/{id}")
    @ApiOperation(value = "find professor info by id")
    public ResultData queryByProfessorId(@PathVariable("id")String id){
        ResultData result = ResultData.success();
        result.setData(professorService.queryById(id));
        return result;
    }

    @PostMapping("/professor")
    @ApiOperation(value = "add a new professor")
    public ResultData addNewProfessor(@RequestBody Professor professor){
        ResultData result = ResultData.success();
        professorService.addProfessor(professor);
        return result;
    }

    @DeleteMapping("/professor/{id}")
    @ApiOperation(value = "wave record of a professor")
    public ResultData waveProfessorRecord(@PathVariable("id") String id){
        ResultData result = ResultData.success();
        professorService.deleteProfessor(id);
        return result;
    }

    @PutMapping("/professor")
    @ApiOperation(value = "update professor's information")
    public ResultData updatedProfessor(@RequestBody Professor professor){
        ResultData result = ResultData.success();

        professorService.updateProfessor(professor);
        return result;
    }
}
