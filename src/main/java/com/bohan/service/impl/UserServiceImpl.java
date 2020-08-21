package com.bohan.service.impl;

import com.bohan.entity.User;
import com.bohan.exception.BaseResponseCodeImp;
import com.bohan.exception.BusinessExceptionIpm;
import com.bohan.mapper.UserMapper;
import com.bohan.service.UserService;
import com.bohan.vo.req.LoginReqVO;
import com.bohan.vo.req.UserAddReqVO;
import com.bohan.vo.resp.LoginRespVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public LoginRespVO login(LoginReqVO loginReqVO) {
        LoginRespVO loginRespVO = new LoginRespVO();

        User user = userMapper.selectByUsername(loginReqVO.getUsername());
        if (user == null) {
            throw new BusinessExceptionIpm(100001,"username dose not exist");
        }
        if (!user.getPassword().equals(loginReqVO.getPassword())){
            throw new BusinessExceptionIpm(100002,"password dose not match");
        }

        BeanUtils.copyProperties(user, loginRespVO);
        return loginRespVO;

    }


    @Override
    public List<User> queryAll() {
        return userMapper.queryAll();
    }

    @Override
    public Boolean usernameIsExist(String username) {

        User user = userMapper.selectByUsername(username);

        if (user == null){
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void addUser(UserAddReqVO vo) {
        User user = new User();

        BeanUtils.copyProperties(vo,user);
        user.setId(UUID.randomUUID().toString());
        user.setCreateTime(new Date().toString());

        int i = userMapper.insertSelective(user);
        if (i != 1){
            throw new BusinessExceptionIpm(BaseResponseCodeImp.DATABASE_ERROR_INSERT);
        }
    }

    @Override
    public void waveUser(String id) {
        int i = userMapper.deleteByPrimaryKey(id);
        if (i != 1) {
            throw new BusinessExceptionIpm(BaseResponseCodeImp.DATABASE_ERROR_DELETE);
        }
    }

    @Override
    public void updateUser(User user) {
        int i = userMapper.updateByPrimaryKeySelective(user);
        if (i != i){
            throw new BusinessExceptionIpm(BaseResponseCodeImp.DATABASE_ERROR_INSERT);
        }
    }

    @Override
    public User queryById(String id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
