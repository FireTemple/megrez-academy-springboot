package com.bohan.controller;


import com.bohan.entity.User;
import com.bohan.service.impl.UserServiceImpl;
import com.bohan.utils.ResultData;
import com.bohan.vo.req.LoginReqVO;
import com.bohan.vo.req.UserAddReqVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping("/users")
    public ResultData queryAll(){
        ResultData resultData = ResultData.success();
        resultData.setData(userService.queryAll());
        return resultData;
    }


    @GetMapping("/user/signup/username/{username}")
    public ResultData checkUsername(@PathVariable("username") String username){
        ResultData resultData = ResultData.success();
        resultData.setData(userService.usernameIsExist(username));
        return resultData;
    }

    @PutMapping("/user/add")
    @ApiOperation(value = "add new user")
    public ResultData addUser(@RequestBody UserAddReqVO vo){
        ResultData resultData = ResultData.success();
        userService.addUser(vo);
        return resultData;
    }
}
