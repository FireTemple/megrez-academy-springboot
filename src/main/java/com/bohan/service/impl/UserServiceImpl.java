package com.bohan.service.impl;

import com.bohan.exception.BusinessExceptionIpm;
import com.bohan.service.UserService;
import com.bohan.vo.req.LoginReqVO;
import com.bohan.vo.resp.LoginRespVO;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Override
    public LoginRespVO login(LoginReqVO loginReqVO) {
        LoginRespVO loginRespVO = new LoginRespVO();

        if (loginReqVO.getUsername().equals("dev")){
            if (loginReqVO.getPassword().equals("111")){
                loginRespVO.setEmail("gk6511@wayne.edu");
                return loginRespVO;
            } else {
                throw new BusinessExceptionIpm(30000,"password incorrect");
            }
        } else {
            throw new BusinessExceptionIpm(300001, "user dose not exist");
        }

    }
}
