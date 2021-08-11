package com.edu.nju.alley.po;

import lombok.Data;

@Data
public class UserPO {

    private Integer userId;

    private String openId;

    private String name;

    private Integer gender;

    private String avatar;

    private Boolean locateAuth;
    
}