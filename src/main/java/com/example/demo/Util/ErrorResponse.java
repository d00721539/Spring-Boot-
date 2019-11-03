package com.example.demo.Util;

import org.springframework.http.ResponseEntity;

public class ErrorResponse {
    public static ErrorObj errorResponse(String message, String reason, String httpStatus){
        ErrorObj errorObj = new ErrorObj();
        errorObj.setHttpStatus(httpStatus);
        errorObj.setMessage(message);
        errorObj.setReason(reason);
        return errorObj;
    }
}
