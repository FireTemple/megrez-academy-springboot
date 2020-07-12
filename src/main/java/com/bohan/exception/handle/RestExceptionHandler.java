package com.bohan.exception.handle;

import com.bohan.exception.BaseResponseCode;
import com.bohan.exception.BaseResponseCodeImp;
import com.bohan.exception.BusinessExceptionIpm;
import com.bohan.utils.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

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

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public <T> ResultData<T> methodArgumentNotValidExceptionHnadler(MethodArgumentNotValidException e){
        log.error("methodArgumentNotValidExceptionHandler bindingResult.allErrors():{},exception:{}",e.getBindingResult().getAllErrors(),e );
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        return createValidExceptionResp(errors);
    }

    private <T> ResultData<T> createValidExceptionResp(List<ObjectError> errors){
        String[] msgs = new String[errors.size()];
        int i = 0;
        for (ObjectError error : errors){
            msgs[i] = error.getDefaultMessage();
            log.info("msg= {}",msgs[i]);
            i ++;
        }
        return ResultData.getResult(BaseResponseCodeImp.METHOD_IDENTITY_ERROR.getCode(),msgs[0]);

    }
}
