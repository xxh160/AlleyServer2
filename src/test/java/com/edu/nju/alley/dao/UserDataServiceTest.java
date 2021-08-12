package com.edu.nju.alley.dao;

import com.edu.nju.alley.constant.Const;
import com.edu.nju.alley.constant.Gender;
import com.edu.nju.alley.po.UserPO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserDataServiceTest {

    private final UserDataService userDataService;

    @Autowired
    public UserDataServiceTest(UserDataService userDataService) {
        this.userDataService = userDataService;
    }

    @Test
    public void insertTest() {
        UserPO user = UserPO.getDefaultInstance("what the fuck");
        user.updateInfo("lzy", Gender.Female.getCode(), Const.NullPicUrl.getId());
        userDataService.insertUser(user);
        System.out.println(user.getUserId());
    }

}
