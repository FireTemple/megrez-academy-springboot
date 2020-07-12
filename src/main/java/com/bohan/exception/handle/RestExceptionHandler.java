package com.bohan.exception.handle;

import com.bohan.exception.BaseResponseCode;
import com.bohan.exception.BaseResponseCodeImp;
import com.bohan.exception.BusinessExceptionIpm;
import com.bohan.utils.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {

    @ExceptionHandler(Exception.class)
    public <T>ResultData<T> handleException(Exception e){
        log.error("Exception, exception:",e);
        return ResultData.getResult(BaseResponseCodeImp.SYSTEM_ERROR);
    }

    @ExceptionHandler(value = BusinessExceptionIpm.class)
    public <T> ResultData<T> businessExceptionHandler(BusinessExceptionIpm exception){
        log.error("BusinessException, exception: {}",exception);
        return new ResultData<>(exception.getCode(), exception.getDefaultMessage());
    }
}
