package com.edu.nju.alley.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArchVO {

    private Integer archId;

    private String name;

    private String des;

    private Double score;

    private String longitude;

    private String latitude;

    private List<String> pictures;

    private List<CommentVO> comments;

}
