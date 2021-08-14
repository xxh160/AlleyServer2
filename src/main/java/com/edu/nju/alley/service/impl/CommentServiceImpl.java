package com.edu.nju.alley.service.impl;

import com.edu.nju.alley.dao.CommentDataService;
import com.edu.nju.alley.dto.ChildCommentDTO;
import com.edu.nju.alley.po.CommentPO;
import com.edu.nju.alley.service.CommentService;
import com.edu.nju.alley.vo.CommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentDataService commentDataService;

    @Autowired
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

    @Override
    public List<CommentVO> userComments(Integer userId) {
        return commentDataService
                .getUserComments(userId)
                .stream()
                .map(cur -> view(cur.getCommentId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<CommentVO> archComments(Integer archId) {
        return commentDataService
                .getArchComments(archId)
                .stream()
                .map(cur -> view(cur.getCommentId()))
                .collect(Collectors.toList());
    }

    //评论一条评论
    @Override
    public CommentVO comment(ChildCommentDTO childCommentDTO) {
        //获得当前时间作为CreateT
        //初始化likeNum为0
        //创建CommentPO并插入
        //返回CommentVO

        //获取当前时间
        Date now = new Date();

        //初始化likeNum
        Integer likeNum = 0;


        return null;
    }

    //点赞或取消点赞评论
    @Override
    public void like(Integer commentId, Integer userId) {
        //插入或删除一条LikePO
        //更新CommentPO中的likeNum
    }

}
