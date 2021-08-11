package com.edu.nju.alley.constant;

import lombok.Getter;

@Getter
public enum Gender {

    Male(1),
    Female(2);

    private final int code;

    Gender(int code) {
        this.code = code;
    }

}
