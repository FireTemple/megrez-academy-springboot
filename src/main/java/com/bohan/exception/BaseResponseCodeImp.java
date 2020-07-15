package com.bohan.exception;

public enum BaseResponseCodeImp implements BaseResponseCode{




    SUCCESS(0,"operation success"),
    SYSTEM_ERROR(200000,"system error, pleases wait"),
    METHOD_IDENTITY_ERROR(100000,"input data error"),
    //error start with 1 means it is data error
    //error start with 2 means it is system error
    //error start with 3 means login error
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
