package com.edu.nju.alley.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LikeVO {

    private Integer userId;

    private Integer commentId;

    private Boolean isLike;

}
