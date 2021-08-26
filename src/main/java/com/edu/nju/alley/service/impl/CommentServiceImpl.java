package com.edu.nju.alley.service.impl;

import com.edu.nju.alley.dao.CommentDataService;
import com.edu.nju.alley.dao.LikeDataService;
import com.edu.nju.alley.dto.ArchCommentDTO;
import com.edu.nju.alley.dto.ChildCommentDTO;
import com.edu.nju.alley.po.CommentPO;
import com.edu.nju.alley.service.CommentService;
import com.edu.nju.alley.service.NoticeService;
import com.edu.nju.alley.service.UserService;
import com.edu.nju.alley.util.NoticeUtil;
import com.edu.nju.alley.vo.CommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentDataService commentDataService;
    private final LikeDataService likeDataService;
    private final NoticeService noticeService;
    private final UserService userService;

    @Autowired
    public CommentServiceImpl(CommentDataService commentDataService,
                              LikeDataService likeDataService,
                              NoticeService noticeService,
                              UserService userService) {
        this.commentDataService = commentDataService;
        this.likeDataService = likeDataService;
        this.noticeService = noticeService;
        this.userService = userService;
    }

    /**
     * 查看一条评论
     *
     * @param commentId 评论 id
     * @return 评论信息
     */
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

    /**
     * 返回用户发表的评论
     *
     * @param userId 用户 id
     * @return 评论信息列表
     */
    @Override
    public List<CommentVO> userComments(Integer userId) {
        return commentDataService
                .getUserComments(userId)
                .stream()
                .map(cur -> view(cur.getCommentId()))
                .collect(Collectors.toList());
    }

    /**
     * 返回关于建筑的评论
     *
     * @param archId 建筑 id
     * @return 评论信息列表
     */
    @Override
    public List<CommentVO> archComments(Integer archId) {
        return commentDataService
                .getArchComments(archId)
                .stream()
                .map(cur -> view(cur.getCommentId()))
                .collect(Collectors.toList());
    }

    /**
     * 评论一条评论
     *
     * @param childCommentDTO 子评论数据
     * @return 评论数据
     */
    @Override
    public CommentVO commentComment(ChildCommentDTO childCommentDTO) {
        // 创建 commentPO
        CommentPO commentPO = CommentPO.childComment(childCommentDTO);
        // 插入 commentPO
        commentDataService.insertComment(commentPO);
        // 评论发布成功 notice
        noticeService.buildSysNotice(childCommentDTO.getUserId(),
                commentPO.getCommentId(),
                NoticeUtil.commentSuccessNotice(commentPO.getContent()));
        // 被评论 notice
        CommentVO fatherComment = this.view(commentPO.getFatherId());
        noticeService.buildCustomNotice(childCommentDTO.getUserId(),
                fatherComment.getUserId(),
                fatherComment.getCommentId(),
                NoticeUtil.commentedNotice(fatherComment.getContent(), userService.view(commentPO.getUserId()).getName()));
        // 返回 CommentVO
        return CommentVO.buildVO(commentPO, null);//新的评论没有子评论，我先放个null在这里
    }

    /**
     * 评论建筑
     *
     * @param archCommentDTO 评论信息
     * @return 生成的评论
     */
    @Override
    public CommentVO commentArch(ArchCommentDTO archCommentDTO) {
        // 创建 CommentPO
        CommentPO commentPO = new CommentPO(archCommentDTO);
        // 插入 CommentPO
        commentDataService.insertComment(commentPO);
        // 发布成功 notice
        noticeService.buildSysNotice(archCommentDTO.getUserId(),
                commentPO.getCommentId(),
                NoticeUtil.commentSuccessNotice(commentPO.getContent()));
        // 返回 CommentVO，新的 CommentPO 没有评论，放个 null 在这里
        return CommentVO.buildVO(commentPO, null);
    }

    /**
     * 点赞或取消点赞评论
     *
     * @param commentId 评论 id
     * @param userId    用户 id
     */
    @Override
    public void like(Integer commentId, Integer userId) {
        // 如果已经点过赞
        if (likeDataService.isExist(userId, commentId)) {
            // 删除点赞记录
            likeDataService.deleteLike(userId, commentId);
            commentDataService.likeDown(commentId);
            return;
        }
        // 尚未点赞
        // 插入一条点赞记录
        likeDataService.insertLike(userId, commentId);
        commentDataService.likeUp(commentId);
    }

}
