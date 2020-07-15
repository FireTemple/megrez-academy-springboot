package com.bohan.controller;


import com.bohan.service.impl.UserServiceImpl;
import com.bohan.utils.ResultData;
import com.bohan.vo.req.LoginReqVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/user/login")
    public ResultData login(@RequestBody @Valid LoginReqVO loginReqVO){
        ResultData resultData = ResultData.success();
        resultData.setData(userService.login(loginReqVO));
        return resultData;
    }
}
