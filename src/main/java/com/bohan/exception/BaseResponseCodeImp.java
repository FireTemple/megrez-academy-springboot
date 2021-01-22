package com.bohan.exception;

public enum BaseResponseCodeImp implements BaseResponseCode{




    SUCCESS(0,"operation success"),
    SYSTEM_ERROR(200000,"system error, pleases wait"),
    METHOD_IDENTITY_ERROR(100000,"input data error"),
    DATA_MISSING(100001,"Missing data"),
    DATABASE_ERROR_INSERT(400001,"insert error"),
    DATABASE_ERROR_UPDATE(400002,"update error"),
    DATABASE_ERROR_DELETE(400003,"delete error"),
    DATABASE_ERROR_QUERY_COURSE(400004,"course is not exist"),
    PAYMENT_ERROR_TOKENMISSING(5000001,"token missing"),
    PAYMENT_ERROR_CHARGE_ERROR(5000002,"charge create error, pleases try later")
    //error start with 1 means it is data error
    //error start with 2 means it is system error
    //error start with 3 means login error
    //error start with 4 means database error
    //error start with 8 menas payment error
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
