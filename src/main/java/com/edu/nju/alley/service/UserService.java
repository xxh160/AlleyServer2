package com.edu.nju.alley.service;

import com.edu.nju.alley.dto.UserDTO;
import com.edu.nju.alley.dto.UserLoginDTO;
import com.edu.nju.alley.vo.LikeVO;
import com.edu.nju.alley.vo.UserVO;

public interface UserService {

    UserVO login(UserLoginDTO userLoginDTO);

    UserVO view(Integer userId);

    UserVO update(UserDTO userDTO);

    LikeVO isLike(Integer userId, Integer commentId);

}
