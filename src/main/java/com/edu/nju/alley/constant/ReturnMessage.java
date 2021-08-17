package com.edu.nju.alley.constant;

import lombok.Getter;

@Getter
public enum ReturnMessage {

    Success("Success."),
    Failure("Failure."),
    UnknownExp("UnknownExp: "),
    WechatExp("Wechat exception, error code: "),
    NoSuchUserExp("No such user."),
    NoSuchCommentExp("No such comment."),
    NoSuchNoticeExp("No such notice.");

    private final String msg;

    ReturnMessage(String msg) {
        this.msg = msg;
    }

}
