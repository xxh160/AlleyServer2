package com.edu.nju.alley.constant;

import lombok.Getter;

@Getter
public enum ReturnMessage {

    Success("Success."),
    Failure("Failure."),
    UnknownExp("UnknownExp: "),
    WechatExp("Wechat exception, error code: "),
    NoSuchUserExp("No such user.");

    private final String msg;

    ReturnMessage(String msg) {
        this.msg = msg;
    }

}
