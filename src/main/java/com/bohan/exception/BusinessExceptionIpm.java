package com.bohan.exception;

public class BusinessExceptionIpm extends RuntimeException{

    // exception code
    private final int code;

    // exception description
    private final String defaultMessage;

    public BusinessExceptionIpm(int code, String defaultMessage){
        super(defaultMessage);
        this.code = code;
        this.defaultMessage = defaultMessage;
    }

    public BusinessExceptionIpm(BaseResponseCodeImp baseResponseCodeImp){
        this(baseResponseCodeImp.getCode(),baseResponseCodeImp.getMsg());
    }

    public int getCode(){
        return code;
    }

    public String getDefaultMessage(){
        return defaultMessage;
    }



}
