package com.edu.nju.alley.po;

import com.edu.nju.alley.constant.Const;
import lombok.Data;

@Data
public class ArchPO {

    private Integer archId;

    private String name;

    private String des;

    private String longitude;

    private String latitude;

    public static ArchPO getNullInstance() {
        ArchPO nullArch = new ArchPO();
        nullArch.setArchId(Integer.parseInt(Const.NullInstanceId.getId()));
        return nullArch;
    }

    public static boolean isNullInstance(ArchPO archPO) {
        return archPO.getArchId().equals(Integer.parseInt(Const.NullInstanceId.getId()));
    }

}