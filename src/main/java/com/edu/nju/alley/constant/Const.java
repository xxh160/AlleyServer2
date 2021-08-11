package com.edu.nju.alley.constant;

import lombok.Getter;

@Getter
public enum Const {

    SystemId(1),
    NullFatherId(-1),
    NullPicUrl(-2);

    private final int id;

    Const(int id) {
        this.id = id;
    }

    public boolean isNullPicUrl(String code) {
        return (Integer.parseInt(code) == NullPicUrl.getId());
    }

}
