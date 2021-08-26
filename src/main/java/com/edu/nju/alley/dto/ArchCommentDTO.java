package com.edu.nju.alley.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArchCommentDTO {

    private Integer archId;

    private Integer userId;

    private String content;

    private String picture;

}
