package com.edu.nju.alley.service;

import com.edu.nju.alley.dto.UserDTO;
import com.edu.nju.alley.dto.UserLoginDTO;
import com.edu.nju.alley.vo.CommentVO;
import com.edu.nju.alley.vo.UserVO;

import java.util.List;

public interface UserService {

    UserVO login(UserLoginDTO userLoginDTO);

    UserVO view(Integer userId);

    UserVO update(UserDTO userDTO);

    List<CommentVO> comments(Integer userId);

}
