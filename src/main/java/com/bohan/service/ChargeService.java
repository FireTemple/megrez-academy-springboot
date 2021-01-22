package com.bohan.service;

import com.bohan.entity.Charge;

import java.util.List;

public interface ChargeService {

    List<Charge> queryAll();

    List<String> queryByCourseId(String id);

    void addNewCharge(Charge charge);

    void cancelCourse(List<String> charges);

    void triggerCourse(List<String> charges);

    Charge queryById(String id);

}
