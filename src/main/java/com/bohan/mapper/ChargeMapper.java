package com.bohan.mapper;

import com.bohan.entity.Charge;

import java.util.List;

public interface ChargeMapper {
    int deleteByPrimaryKey(String id);

    int insert(Charge record);

    int insertSelective(Charge record);

    Charge selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Charge record);

    int updateByPrimaryKey(Charge record);

    List<Charge> queryAll();

    List<String> queryByCourseId(String courseId);

    int cancelCharge(String id);

    int triggerCharge(Charge charge);
}