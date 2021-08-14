package com.edu.nju.alley.vo;

import com.edu.nju.alley.po.ArchPO;
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

    public static ArchVO buildVO(ArchPO arch,Double score,List<String> pictures,List<CommentVO> comments){
        return new ArchVO(arch.getArchId(),
                arch.getName(),
                arch.getDes(),
                score,
                arch.getLongitude(),
                arch.getLatitude(),
                pictures,
                comments);
    }

}
