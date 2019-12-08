package com.lucene.test.config.error.exception;

/**
 * Created by zhang_htao on 2019/12/5.
 */


public class CustomGenericException extends RuntimeException{
    private String errorCode;
    private String errmsg;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public CustomGenericException(String errorCode, String errmsg) {
        this.errorCode = errorCode;
        this.errmsg = errmsg;
    }
}
