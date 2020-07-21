package com.bohan.utils;

import com.bohan.exception.BaseResponseCode;
import com.bohan.exception.BaseResponseCodeImp;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ResultData<T> {


    @ApiModelProperty(value = "response code,0 is success, other else is failure",name = "code")
    private int code = 0;

    @ApiModelProperty(value = "response message",name = "msg")
    private String msg;

    @ApiModelProperty(value = "response data", name = "data")
    private T data;

    public ResultData(int code, T data){
        this.code = code;
        this.data = data;
    }

    public ResultData(int code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultData(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public ResultData(T data){
        this.data = data;
        this.msg = BaseResponseCodeImp.SUCCESS.getMsg();
        this.code = BaseResponseCodeImp.SUCCESS.getCode();
    }

    public ResultData(){
        this.code = BaseResponseCodeImp.SUCCESS.getCode();
        this.msg = BaseResponseCodeImp.SUCCESS.getMsg();
        this.data = null;
    }

    public ResultData(BaseResponseCode baseResponseCode){
        this.data = null;
        this.code = baseResponseCode.getCode();
        this.msg = baseResponseCode.getMsg();
    }


    public ResultData(BaseResponseCode baseResponseCode, T data){
        this.data = data;
        this.code = baseResponseCode.getCode();
        this.msg = baseResponseCode.getMsg();
    }

    /**
     * six kinds of data can be returned
     * @param
     * @return
     */

    // operation success without data
    public static ResultData success(){
        return new ResultData();
    }

    // operation success with data
    public static <T>ResultData success(T data){

        return new <T>ResultData(data);
    }

    //custom return data
    public static <T>ResultData getResult(int code, String msg, T data){
        return new <T>ResultData(code, msg, data);
    }

    public static <T>ResultData getResult(int code, String msg){
        return new <T>ResultData(code,msg);
    }

    public static <T>ResultData getResult(BaseResponseCodeImp responseCode){
        return new <T>ResultData(responseCode);
    }

    public static <T>ResultData getResult(BaseResponseCodeImp responseCode, T data){
        return new <T>ResultData(responseCode, data);
    }
}

