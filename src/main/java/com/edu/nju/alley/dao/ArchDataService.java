package com.edu.nju.alley.dao;

import com.edu.nju.alley.po.ArchPO;
import com.edu.nju.alley.po.ArchPicturePO;

import java.util.List;

public interface ArchDataService {

    ArchPO getArch(Integer archId);

    List<ArchPicturePO> getArchPicture(Integer archId);

}
