package com.bohan.service.impl;

import com.bohan.entity.Charge;
import com.bohan.exception.BaseResponseCodeImp;
import com.bohan.exception.BusinessExceptionIpm;
import com.bohan.mapper.ChargeMapper;
import com.bohan.service.ChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ChargeServiceImpl implements ChargeService {

    @Autowired
    ChargeMapper chargeMapper;

    @Override
    public List<Charge> queryAll() {
        return chargeMapper.queryAll();
    }

    @Override
    public List<String> queryByCourseId(String id) {
        return chargeMapper.queryByCourseId(id);
    }

    @Override
    public void addNewCharge(Charge charge) {
        int i = chargeMapper.insertSelective(charge);
        if (i != 1){
            throw new BusinessExceptionIpm(BaseResponseCodeImp.DATABASE_ERROR_INSERT);
        }
    }

    @Override
    @Transactional
    public void cancelCourse(List<String> charges) {

        for (String id : charges){
            int i = chargeMapper.cancelCharge(id);
            if (i != 1){
                throw new BusinessExceptionIpm(BaseResponseCodeImp.DATABASE_ERROR_UPDATE);
            }
        }

    }

    @Override
    @Transactional
    public void triggerCourse(List<String> charges) {

        for (String id : charges){
            int i = chargeMapper.triggerCharge(id);
            if (i != 1){
                throw new BusinessExceptionIpm(BaseResponseCodeImp.DATABASE_ERROR_UPDATE);
            }
        }
    }


}
