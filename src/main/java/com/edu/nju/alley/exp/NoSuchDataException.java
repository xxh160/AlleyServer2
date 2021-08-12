package com.edu.nju.alley.exp;

import lombok.Getter;

@Getter
public class NoSuchDataException extends RuntimeException {

    public NoSuchDataException(String msg) {
        super(msg);
    }

}
