package com.edu.nju.alley.constant;

import lombok.Getter;

@Getter
public enum ReturnMessage {

    Success("Success."),
    Failure("Failure."),
    UnknownExp("UnknownExp: ");

    private String msg;

    ReturnMessage(String msg) {
        this.msg = msg;
    }

    void setMessage(String msg) {
        this.msg = "Custom. " + msg;
    }

}
