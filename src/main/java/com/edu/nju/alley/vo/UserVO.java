package com.edu.nju.alley.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {

    private Integer userId;

    private String name;

    private Integer gender;

    private String avatar;

    private Boolean locateAuth;

}
