package com.edu.nju.alley.service;

import com.edu.nju.alley.dto.UserLoginDTO;
import com.edu.nju.alley.vo.UserVO;

public interface UserService {

    UserVO login(UserLoginDTO userLoginDTO);

}
