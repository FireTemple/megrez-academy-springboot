package com.bohan.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Api(tags = "views")
@RequestMapping("/index")
public class IndexController {

    @GetMapping("/404")
    @ApiOperation(value = "404 error page")
    public String error404(){
        return "error/404";
    }

    @GetMapping("/login")
    @ApiOperation(value = "login page")
    public String login(){
        return "login";
    }

    @GetMapping("/home")
    @ApiOperation(value = "home page")
    public String goHome(){
        return "home";
    }

    @GetMapping("/main")
    @ApiOperation(value = "main page when user just login")
    public String goMain(){
        return "main";
    }

    @GetMapping("/user")
    @ApiOperation(value = "user page")
    public String goUser(){
        return "user/user";
    }

    @GetMapping("/course")
    @ApiOperation(value = "go to course page")
    public String goCourse(){
        return "course/course";
    }

    @GetMapping("/student")
    @ApiOperation(value = "go to student page")
    public String goStudent(){
        return "student/student";
    }

    @GetMapping("/course/add")
    @ApiOperation(value = "go to add course page")
    public String goRegister(){
        return "course/add_course";
    }



    @GetMapping("/signup")
    @ApiOperation(value = "go to signup page")
    public String goSignup(){
        return "signup";
    }

    @GetMapping("/student/add")
    @ApiOperation(value = "go to add student page")
    public String goAddKid(){
        return "student/add_student";
    }



    @GetMapping("/test")
    @ApiOperation(value = "go to test page")
    public String goTest(){
        return "test";
    }
}
