package com.bohan.controller;


import com.bohan.service.impl.HomeServiceImpl;
import com.bohan.utils.ResultData;
import com.bohan.vo.resp.HomeRespVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Api(tags = "Home page Data")
@RequestMapping("/api")
public class HomeController {

    @Autowired
    HomeServiceImpl homeService;

    @GetMapping("/home")
    @ApiOperation(value = "get home data")
    public ResultData<HomeRespVO> getHomeData(HttpServletRequest request){

        String userId = request.getHeader("userId");

        ResultData result = ResultData.success();
        result.setData(homeService.getHomeData(userId));

        return result;
    }

}
