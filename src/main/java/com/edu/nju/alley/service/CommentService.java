package com.edu.nju.alley.service;

import com.edu.nju.alley.dto.ArchCommentDTO;
import com.edu.nju.alley.dto.ChildCommentDTO;
import com.edu.nju.alley.vo.CommentVO;

import java.util.List;

public interface CommentService {

    CommentVO view(Integer commentId);

    List<CommentVO> userComments(Integer userId);

    List<CommentVO> archComments(Integer archId);

    CommentVO commentComment(ChildCommentDTO childCommentDTO);

    CommentVO commentArch(ArchCommentDTO archCommentDTO);

    void like(Integer commentId, Integer userId);

}
