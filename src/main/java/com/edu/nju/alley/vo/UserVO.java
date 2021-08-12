package com.edu.nju.alley.vo;

import com.edu.nju.alley.po.UserPO;
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

    public static UserVO buildVO(UserPO user) {
        return new UserVO(user.getUserId(), user.getName(), user.getGender(), user.getAvatar(), user.getLocateAuth());
    }

}
