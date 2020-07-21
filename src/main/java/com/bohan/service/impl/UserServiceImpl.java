package com.bohan.service.impl;

import com.bohan.entity.User;
import com.bohan.exception.BusinessExceptionIpm;
import com.bohan.mapper.UserMapper;
import com.bohan.service.UserService;
import com.bohan.vo.req.LoginReqVO;
import com.bohan.vo.resp.LoginRespVO;
import com.bohan.vo.resp.StudentRespVO;
import com.fasterxml.jackson.databind.BeanProperty;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public LoginRespVO login(LoginReqVO loginReqVO) {
        LoginRespVO loginRespVO = new LoginRespVO();

        if (loginReqVO.getUsername().equals("dev")){
            if (loginReqVO.getPassword().equals("111")){
                BeanUtils.copyProperties(loginRespVO,loginReqVO);
//                loginRespVO.setEmail("gk6511@wayne.edu");
                loginRespVO.setUserId("1");
                return loginRespVO;
            } else {
                throw new BusinessExceptionIpm(30000,"password incorrect");
            }
        } else {
            throw new BusinessExceptionIpm(300001, "user dose not exist");
        }

    }


    @Override
    public List<User> queryAll() {
        return userMapper.queryAll();
    }
}
