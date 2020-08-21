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

    @PostMapping("/user")
    @ApiOperation(value = "add new user")
    public ResultData addUser(@RequestBody UserAddReqVO vo){
        ResultData resultData = ResultData.success();
        userService.addUser(vo);
        return resultData;
    }

    @DeleteMapping("/user/{id}")
    @ApiOperation(value = "wave data from database")
    public ResultData waveUserRecord(@PathVariable("id") String id){
        ResultData result = ResultData.success();
        userService.waveUser(id);
        return result;
    }

    @PutMapping("/user")
    @ApiOperation(value = "update user for both admin and users")
    public ResultData updateUser(@RequestBody User user){
        ResultData result = ResultData.success();
        userService.updateUser(user);
        return result;
    }

    @GetMapping("/user/{id}")
    @ApiOperation(value = "find user by user id")
    public ResultData queryUserById(@PathVariable("id")String id){
        ResultData result = ResultData.success();
        result.setData(userService.queryById(id));
        return result;
    }
}
