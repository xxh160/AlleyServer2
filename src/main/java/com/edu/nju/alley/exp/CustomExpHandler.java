package com.edu.nju.alley.exp;

import com.edu.nju.alley.constant.ReturnMessage;
import com.edu.nju.alley.vo.ResponseVO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExpHandler {

    @ExceptionHandler(value = NoSuchDataException.class)
    public ResponseVO<Object> customExceptionHandler(NoSuchDataException e) {
        return ResponseVO.failure().msg(e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseVO<Object> exceptionHandler(Exception e) {
        return ResponseVO.failure().msg(ReturnMessage.UnknownExp.getMsg() + e.getMessage());
    }

}