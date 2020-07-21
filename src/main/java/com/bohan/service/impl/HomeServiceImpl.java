package com.bohan.service.impl;

import com.bohan.service.HomeService;
import com.bohan.vo.resp.HomeRespVO;
import org.springframework.stereotype.Service;


@Service
public class HomeServiceImpl  implements HomeService {

    @Override
    public HomeRespVO getHomeData(String userId) {
        HomeRespVO homeRespVO = new HomeRespVO();

        homeRespVO.setUserId(userId);
        homeRespVO.setUsername("bohan");

        return homeRespVO;
    }
}
