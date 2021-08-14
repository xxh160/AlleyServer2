package com.edu.nju.alley.vo;

import com.edu.nju.alley.po.ArchPO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArchViewVO {

    private Integer archId;

    private String longitude;

    private String latitude;

    public ArchViewVO(ArchPO archPO){
        this.archId=archPO.getArchId();
        this.longitude=archPO.getLongitude();
        this.latitude=archPO.getLatitude();
    }

}
