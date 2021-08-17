package com.edu.nju.alley.po;

import com.edu.nju.alley.constant.Const;
import lombok.Data;

@Data
public class UserPO {

    private Integer userId;

    private String openId;

    private String name;

    private Integer gender;

    private String avatar;

    private Boolean locateAuth;

    public void updateInfo(String name, Integer gender, String avatar) {
        this.name = name;
        this.gender = gender;
        this.avatar = avatar;
    }
    
    public static UserPO getNullInstance() {
        UserPO nullUser = new UserPO();
        nullUser.setUserId(Integer.parseInt(Const.NullInstanceId.getId()));
        return nullUser;
    }

    public static boolean isNullInstance(UserPO userPO) {
        return userPO.getUserId().equals(Integer.parseInt(Const.NullInstanceId.getId()));
    }

    public static UserPO getDefaultInstance(String openId) {
        UserPO defaultUser = new UserPO();
        defaultUser.setOpenId(openId);
        defaultUser.setLocateAuth(false);
        return defaultUser;
    }

}