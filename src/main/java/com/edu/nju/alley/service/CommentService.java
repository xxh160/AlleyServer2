package com.edu.nju.alley.service;

import com.edu.nju.alley.dto.ChildCommentDTO;
import com.edu.nju.alley.vo.CommentVO;

import java.util.List;

public interface CommentService {

    CommentVO view(Integer commentId);

    // api 设计严重失误
    List<CommentVO> userComments(Integer userId);

    List<CommentVO> archComments(Integer archId);

    CommentVO comment(ChildCommentDTO childCommentDTO);

    Object like(Integer commentId,Integer userId);

}
