package com.edu.nju.alley.dto;

import lombok.Data;

@Data
public class ChildCommentDTO {

    private Integer archId;

    private Integer fatherId;

    private Integer userId;

    private String content;

    private String picture;

}
