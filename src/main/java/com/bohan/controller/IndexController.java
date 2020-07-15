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
}
