package com.edu.nju.alley.po;

import com.edu.nju.alley.constant.Const;
import com.edu.nju.alley.dto.ArchCommentDTO;
import com.edu.nju.alley.dto.ChildCommentDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class CommentPO {

    private Integer commentId;

    private Integer archId;

    private Integer userId;

    private Integer fatherId;

    private String content;

    private Integer likeNum;

    private Date createT;

    private String picture;

    public static CommentPO getNullInstance() {
        CommentPO nullComment = new CommentPO();
        nullComment.setCommentId(Integer.parseInt(Const.NullInstanceId.getId()));
        return nullComment;
    }

    public static boolean isNullInstance(CommentPO comment) {
        return comment.getCommentId().equals(Integer.parseInt(Const.NullInstanceId.getId()));
    }

    public CommentPO(ChildCommentDTO childCommentDTO) {
        this.archId = childCommentDTO.getArchId();
        this.userId = childCommentDTO.getUserId();
        this.fatherId = childCommentDTO.getFatherId();
        this.content = childCommentDTO.getContent();
        this.picture = childCommentDTO.getPicture();
        this.likeNum = Integer.parseInt(Const.NullLikeNum.getId());
        this.createT = new Date();
    }

    public CommentPO(ArchCommentDTO archCommentDTO) {
        this.archId = archCommentDTO.getArchId();
        this.userId = archCommentDTO.getUserId();
        this.fatherId = Integer.parseInt(Const.NullFatherId.getId());
        this.content = archCommentDTO.getContent();
        this.picture = archCommentDTO.getPicture();
        this.likeNum = Integer.parseInt(Const.NullLikeNum.getId());
        this.createT = new Date();
    }

    public static CommentPO childComment(ChildCommentDTO childCommentDTO) {
        return new CommentPO(childCommentDTO);
    }

    public static CommentPO archComment(ArchCommentDTO archCommentDTO) {
        return new CommentPO(archCommentDTO);
    }
}