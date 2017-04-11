package net.Response;

import com.example.hh.common_util.ResponseBean;

/**
 * Created by Administrator on 2017/4/10 0010.
 */

public class BaseResponse extends ResponseBean{

    //根请求，公共返回值
    /**
     * IsSuccess : true
     * ErrorCode : 0
     * Message : string
     */

    private boolean IsSuccess;
    private int ErrorCode;
    private String Message;

    public boolean isIsSuccess() {
        return IsSuccess;
    }

    public void setIsSuccess(boolean IsSuccess) {
        this.IsSuccess = IsSuccess;
    }

    public int getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(int ErrorCode) {
        this.ErrorCode = ErrorCode;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public void setAuthError() {
        IsSuccess = false;
        ErrorCode = 401;
    }

    public boolean isAuthError() {
        return ErrorCode == 401;
    }
}
