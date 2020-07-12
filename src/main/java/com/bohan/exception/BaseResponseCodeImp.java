package com.bohan.exception;

public enum BaseResponseCodeImp implements BaseResponseCode{




    SUCCESS(0,"operation success"),
    SYSTEM_ERROR(200000,"system error, pleases wait")
    //error start with 1 means it is data error missing data
    ;


    private int code;
    private String msg;

    BaseResponseCodeImp(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }



}
