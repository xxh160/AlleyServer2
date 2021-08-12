package com.edu.nju.alley.vo;

import com.edu.nju.alley.po.CommentPO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentVO {

    private Integer commentId;

    private Integer archId;

    private Integer fatherId;

    private Integer userId;

    private Integer likeNum;

    private Date createT;

    private String picture;

    private List<CommentVO> children;

    public static CommentVO buildVO(CommentPO comment, List<CommentVO> children) {
        return new CommentVO(comment.getCommentId(),
                comment.getArchId(),
                comment.getFatherId(),
                comment.getUserId(),
                comment.getLikeNum(),
                comment.getCreateT(),
                comment.getPicture(),
                children);
    }

}
