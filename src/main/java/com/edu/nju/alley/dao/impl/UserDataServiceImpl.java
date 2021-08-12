package com.edu.nju.alley.dao.impl;

import com.edu.nju.alley.dao.UserDataService;
import com.edu.nju.alley.dao.mapper.UserMapper;
import com.edu.nju.alley.dao.support.UserDSS;
import com.edu.nju.alley.po.UserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Service
public class UserDataServiceImpl implements UserDataService {

    private final UserMapper userMapper;

    @Autowired
    public UserDataServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserPO getUser(String openId) {
        Optional<UserPO> userOptional = userMapper
                .selectOne(c -> c.where(UserDSS.openId, isEqualTo(openId)));
        return userOptional.orElse(UserPO.getNullInstance());
    }

    @Override
    public void insertUser(UserPO user) {
        userMapper.insert(user);
    }

    @Override
    public void updateUser(UserPO user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

}
