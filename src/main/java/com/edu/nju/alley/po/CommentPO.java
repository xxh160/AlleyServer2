package com.edu.nju.alley.po;

import com.edu.nju.alley.constant.Const;
import com.edu.nju.alley.dto.ArchCommentDTO;
import com.edu.nju.alley.dto.ChildCommentDTO;
import lombok.Data;

import java.util.Date;

@Data
public class CommentPO {

    private Integer commentId;

    private Integer archId;

    private Integer userId;

    private Integer fatherId;

    private String content;

    private Integer likeNum;

    private Date createT;

    private String picture;

    private static CommentPO nullComment;

    public CommentPO() {
    }

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

    public CommentPO(ChildCommentDTO childCommentDTO) {
        this.archId = childCommentDTO.getArchId();
        this.userId = childCommentDTO.getUserId();
        this.fatherId = childCommentDTO.getFatherId();
        this.content = childCommentDTO.getContent();
        this.picture=childCommentDTO.getPicture();
        this.likeNum=0;
        this.createT=new Date();
    }

    public CommentPO(ArchCommentDTO archCommentDTO){
        this.archId=archCommentDTO.getArchId();
        this.userId=archCommentDTO.getUserId();
        this.fatherId=-1;
        this.content=archCommentDTO.getContent();
        this.picture=archCommentDTO.getPicture();
        this.likeNum=0;
        this.createT=new Date();
    }


    public static CommentPO childComment(ChildCommentDTO childCommentDTO){
        return new CommentPO(childCommentDTO);
    }

    public static CommentPO archComment(ArchCommentDTO archCommentDTO){return new CommentPO(archCommentDTO);}
}