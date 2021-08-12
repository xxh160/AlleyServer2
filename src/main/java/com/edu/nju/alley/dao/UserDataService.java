package com.edu.nju.alley.dao;

import com.edu.nju.alley.po.UserPO;

public interface UserDataService {

    UserPO getUser(String openId);

}
