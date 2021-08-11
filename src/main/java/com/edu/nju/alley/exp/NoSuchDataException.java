package com.edu.nju.alley.exp;

import com.edu.nju.alley.constant.ReturnMessage;
import lombok.Getter;

@Getter
public class NoSuchDataException extends RuntimeException {

    public NoSuchDataException(ReturnMessage msg) {
        super(msg.getMsg());
    }

}
