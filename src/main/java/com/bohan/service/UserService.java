package com.bohan.service;

import com.bohan.entity.User;
import com.bohan.vo.req.LoginReqVO;
import com.bohan.vo.req.UserAddReqVO;
import com.bohan.vo.resp.LoginRespVO;

import java.util.List;


public interface UserService {

    LoginRespVO login(LoginReqVO loginReqVO);

    List<User> queryAll();

    Boolean usernameIsExist(String username);

    void addUser(UserAddReqVO vo);

    void waveUser(String id);

    void updateUser(User user);

    User queryById(String id);
}
