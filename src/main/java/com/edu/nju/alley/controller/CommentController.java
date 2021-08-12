package com.edu.nju.alley.controller;

import com.edu.nju.alley.dto.ChildCommentDTO;
import com.edu.nju.alley.service.CommentService;
import com.edu.nju.alley.vo.CommentVO;
import com.edu.nju.alley.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/comment")
    public ResponseVO<CommentVO> comment(@RequestBody ChildCommentDTO childCommentDTO) {
        return null;
    }

    @PostMapping("/like/{commentId}")
    public ResponseVO<Object> like(@PathVariable Integer commentId, @RequestParam Integer userId) {
        return null;
    }

    @GetMapping("/view/{commentId}")

    public ResponseVO<CommentVO> view(@PathVariable Integer commentId) {
        return null;
    }

}
