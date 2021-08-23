package com.edu.nju.alley.vo;

import com.edu.nju.alley.constant.ReturnCode;
import com.edu.nju.alley.constant.ReturnMessage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseVO<T> {

    public Integer code;

    public String msg;

    public T data;

    public ResponseVO<T> code(Integer code) {
        this.code = code;
        return this;
    }

    public ResponseVO<T> msg(String msg) {
        this.msg = msg;
        return this;
    }

    public ResponseVO<T> data(T data) {
        this.data = data;
        return this;
    }

    public static <T> ResponseVO<T> build() {
        return new ResponseVO<>();
    }

    public static <T> ResponseVO<T> success() {
        return ResponseVO.<T>build()
                .code(ReturnCode.Success.getCode())
                .msg(ReturnMessage.Success.getMsg());
    }

    public static <T> ResponseVO<T> failure() {
        return ResponseVO.<T>build()
                .code(ReturnCode.Failure.getCode())
                .msg(ReturnMessage.Failure.getMsg());
    }

}
