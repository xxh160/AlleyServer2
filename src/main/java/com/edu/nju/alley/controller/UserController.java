package com.edu.nju.alley.controller;

import com.edu.nju.alley.dto.UserDTO;
import com.edu.nju.alley.dto.UserLoginDTO;
import com.edu.nju.alley.service.UserService;
import com.edu.nju.alley.vo.CommentVO;
import com.edu.nju.alley.vo.ResponseVO;
import com.edu.nju.alley.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseVO<UserVO> login(@RequestBody UserLoginDTO userLoginDTO) {
        return ResponseVO
                .<UserVO>success()
                .data(userService.login(userLoginDTO));
    }

    @GetMapping("/view/{userId}")
    public ResponseVO<UserVO> view(@PathVariable Integer userId) {
        return null;
    }

    @PostMapping("/update")
    public ResponseVO<UserVO> update(@RequestBody UserDTO userDTO) {
        return null;
    }

    @GetMapping("/comments/{userId}")
    public ResponseVO<List<CommentVO>> comments(@PathVariable Integer userId) {
        return null;
    }

}
