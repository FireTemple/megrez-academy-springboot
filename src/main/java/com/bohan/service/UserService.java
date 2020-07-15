package com.bohan.service;

import com.bohan.vo.req.LoginReqVO;
import com.bohan.vo.resp.LoginRespVO;
import org.springframework.stereotype.Service;


public interface UserService {

    LoginRespVO login(LoginReqVO loginReqVO);
}
