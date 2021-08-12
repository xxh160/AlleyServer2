package com.edu.nju.alley.service.impl;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.edu.nju.alley.api.WechatService;
import com.edu.nju.alley.config.WechatConfig;
import com.edu.nju.alley.constant.ReturnMessage;
import com.edu.nju.alley.dao.UserDataService;
import com.edu.nju.alley.dto.UserLoginDTO;
import com.edu.nju.alley.exp.NoSuchDataException;
import com.edu.nju.alley.po.UserPO;
import com.edu.nju.alley.service.UserService;
import com.edu.nju.alley.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final WechatService wechatService;
    private final WechatConfig wechat;
    private final UserDataService userDataService;

    @Autowired
    public UserServiceImpl(WechatService wechatService,
                           WechatConfig wechat,
                           UserDataService userDataService) {
        this.wechatService = wechatService;
        this.wechat = wechat;
        this.userDataService = userDataService;
    }

    @Override
    public UserVO login(UserLoginDTO userLoginDTO) {
        // 调用微信登录 api
        JSONObject json = JSONUtil.parseObj(wechatService.getUserOpenId(
                wechat.getAppId(),
                wechat.getAppSecret(),
                userLoginDTO.getCode(),
                "authorization_code"));
        String error = json.getStr("errcode");
        if (error != null) {
            int errCode = Integer.parseInt(error);
            // 错误码非 0，出错
            if (errCode != 0) throw new NoSuchDataException(ReturnMessage.WechatExp.getMsg() + errCode);
        }
        String openId = json.getStr("openid");
        UserPO user = userDataService.getUser(openId);

        // 没有这个用户 注册
        if (UserPO.isNullInstance(user)) {
            user = UserPO.getDefaultInstance(openId);
            user.updateInfo(userLoginDTO.getName(), userLoginDTO.getGender(), userLoginDTO.getAvatar());

        }

        return null;
    }

}
