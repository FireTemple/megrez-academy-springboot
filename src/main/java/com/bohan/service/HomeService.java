package com.bohan.service;

import com.bohan.vo.resp.HomeRespVO;

public interface HomeService {

    HomeRespVO getHomeData(String userId);
}
