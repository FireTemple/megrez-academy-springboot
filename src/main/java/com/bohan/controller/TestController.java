package com.bohan.controller;

import com.bohan.exception.BaseResponseCode;
import com.bohan.exception.BaseResponseCodeImp;
import com.bohan.exception.BusinessExceptionIpm;
import com.bohan.utils.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "testing API")
@RequestMapping("/test")
public class TestController {

    @GetMapping("/index")
    @ApiOperation(value = "view entry")
    public String testResult(){
        return "hello world";
    }

    @GetMapping("/home")
    @ApiOperation(value = "testing result data")
    public ResultData<String> testResultData(){
        return ResultData.success("asdasdasda");
    }

    @GetMapping("/error")
    @ApiOperation(value = "test global exception handler")
    public ResultData<String> testError(){
        int i = 1 / 0 ;
        return ResultData.success();
    }

    @GetMapping("/business/error")
    @ApiOperation(value = "test business exception handler")
    public ResultData<String> testBusinessError(@RequestParam String type){
        if (type.equals("1") || type.equals("2") || type.equals("3")){
            throw  new BusinessExceptionIpm(BaseResponseCodeImp.SYSTEM_ERROR);
        }

        return ResultData.success(type);
    }

}
