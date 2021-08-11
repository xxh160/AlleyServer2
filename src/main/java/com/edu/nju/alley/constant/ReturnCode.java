package com.edu.nju.alley.constant;

import lombok.Getter;

@Getter
public enum ReturnCode {

    Success(1),
    Failure(-1);

    private final int code;

    ReturnCode(int code) {
        this.code = code;
    }

}
