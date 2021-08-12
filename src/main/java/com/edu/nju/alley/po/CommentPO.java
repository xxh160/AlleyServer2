package com.edu.nju.alley.po;

import com.edu.nju.alley.constant.Const;
import lombok.Data;

import java.util.Date;

@Data
public class CommentPO {

    private Integer commentId;

    private Integer archId;

    private Integer userId;

    private Integer fatherId;

    private Integer content;

    private Integer likeNum;

    private Date createT;

    private String picture;

    private static CommentPO nullComment;

    public static CommentPO getNullInstance() {
        if (nullComment == null) {
            nullComment = new CommentPO();
            nullComment.setCommentId(Integer.parseInt(Const.NullInstanceId.getId()));
        }
        return nullComment;
    }

    public static boolean isNullInstance(CommentPO comment) {
        if (nullComment == null) {
            nullComment = new CommentPO();
            nullComment.setCommentId(Integer.parseInt(Const.NullInstanceId.getId()));
        }
        return comment.getCommentId().equals(nullComment.getCommentId());
    }

}