package com.edu.nju.alley.controller;

import com.edu.nju.alley.dto.UserDTO;
import com.edu.nju.alley.dto.UserLoginDTO;
import com.edu.nju.alley.service.UserService;
import com.edu.nju.alley.vo.*;
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
        return ResponseVO
                .<UserVO>success()
                .data(userService.view(userId));
    }

    @PostMapping("/update")
    public ResponseVO<UserVO> update(@RequestBody UserDTO userDTO) {
        return ResponseVO
                .<UserVO>success()
                .data(userService.update(userDTO));
    }

    @GetMapping("/comments/{userId}")
    public ResponseVO<List<CommentVO>> comments(@PathVariable Integer userId) {
        return null;
    }

    @GetMapping("/comment/is_like/{userId}")
    public ResponseVO<LikeVO> isLike(@PathVariable Integer userId, @RequestParam Integer commentId) {
        return null;
    }

    @GetMapping("/notices/{userId}")
    public ResponseVO<List<NoticeVO>> notices(@PathVariable Integer userId) {
        return null;
    }

}
