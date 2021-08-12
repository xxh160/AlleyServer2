package com.edu.nju.alley.service.impl;

import com.edu.nju.alley.dao.CommentDataService;
import com.edu.nju.alley.po.CommentPO;
import com.edu.nju.alley.service.CommentService;
import com.edu.nju.alley.vo.CommentVO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentDataService commentDataService;

    public CommentServiceImpl(CommentDataService commentDataService) {
        this.commentDataService = commentDataService;
    }

    @Override
    public CommentVO view(Integer commentId) {
        CommentPO comment = commentDataService.getComment(commentId);
        // 可能出 bug：children 为空
        List<CommentVO> children = commentDataService
                .getChildComments(commentId)
                .stream()
                .map(cur -> view(cur.getCommentId()))
                .collect(Collectors.toList());
        return CommentVO.buildVO(comment, children);
    }

}
