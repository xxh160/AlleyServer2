package com.edu.nju.alley.vo;

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

    private Boolean isLike;

    private String picture;

    private List<CommentVO> children;

}
