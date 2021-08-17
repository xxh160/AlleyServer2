package com.edu.nju.alley.service.impl;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.edu.nju.alley.api.WechatService;
import com.edu.nju.alley.config.WechatConfig;
import com.edu.nju.alley.constant.ReturnMessage;
import com.edu.nju.alley.dao.LikeDataService;
import com.edu.nju.alley.dao.UserDataService;
import com.edu.nju.alley.dto.UserDTO;
import com.edu.nju.alley.dto.UserLoginDTO;
import com.edu.nju.alley.exp.NoSuchDataException;
import com.edu.nju.alley.po.UserPO;
import com.edu.nju.alley.service.UserService;
import com.edu.nju.alley.vo.LikeVO;
import com.edu.nju.alley.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final WechatService wechatService;
    private final WechatConfig wechat;
    private final UserDataService userDataService;
    private final LikeDataService likeDataService;

    @Autowired
    public UserServiceImpl(WechatService wechatService,
                           WechatConfig wechat,
                           UserDataService userDataService,
                           LikeDataService likeDataService) {
        this.wechatService = wechatService;
        this.wechat = wechat;
        this.userDataService = userDataService;
        this.likeDataService = likeDataService;
    }

    /**
     * 用户登录
     *
     * @param userLoginDTO 登录信息
     * @return 用户信息
     */
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
            userDataService.insertUser(user);
            return UserVO.buildVO(user);
        }

        //  存在这个用户 更新
        user.updateInfo(userLoginDTO.getName(), userLoginDTO.getGender(), userLoginDTO.getAvatar());
        userDataService.updateUser(user);
        return UserVO.buildVO(user);
    }

    /**
     * 查看用户信息
     *
     * @param userId 用户 id
     * @return 用户信息
     */
    @Override
    public UserVO view(Integer userId) {
        UserPO user = userDataService.getUser(userId);
        if (UserPO.isNullInstance(user)) throw new NoSuchDataException(ReturnMessage.NoSuchUserExp.getMsg());
        return UserVO.buildVO(user);
    }

    /**
     * 更新用户信息
     *
     * @param userDTO 用户信息
     * @return 用户信息
     */
    @Override
    public UserVO update(UserDTO userDTO) {
        UserPO user = userDataService.getUser(userDTO.getUserId());
        if (UserPO.isNullInstance(user)) throw new NoSuchDataException(ReturnMessage.NoSuchUserExp.getMsg());
        user.setLocateAuth(userDTO.getLocateAuth());
        userDataService.updateUser(user);
        return UserVO.buildVO(user);
    }

    /**
     * 用户是否点赞
     *
     * @param userId    用户 id
     * @param commentId 评论 id
     * @return 是否点赞
     */
    @Override
    public LikeVO isLike(Integer userId, Integer commentId) {
        return new LikeVO(userId, commentId, likeDataService.isExist(userId, commentId));
    }

}
