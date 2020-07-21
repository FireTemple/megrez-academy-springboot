package com.bohan.service;

import com.bohan.entity.User;
import com.bohan.vo.req.LoginReqVO;
import com.bohan.vo.resp.LoginRespVO;
import com.bohan.vo.resp.StudentRespVO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    LoginRespVO login(LoginReqVO loginReqVO);

    List<User> queryAll();
}
