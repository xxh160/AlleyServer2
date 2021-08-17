package com.edu.nju.alley.constant;

import lombok.Getter;

@Getter
public enum Const {

    SystemId("1"),
    NullInstanceId("-1"),
    NullFatherId("-1"),
    NullPicUrl("-2"),
    NullOpenId("null"),
    NullLikeNum("0");

    private final String id;

    Const(String id) {
        this.id = id;
    }

    public boolean isNullPicUrl(String code) {
        return code.equals(NullPicUrl.getId());
    }

}
