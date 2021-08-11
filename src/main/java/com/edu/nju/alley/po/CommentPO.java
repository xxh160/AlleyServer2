package com.edu.nju.alley.po;

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
    
}