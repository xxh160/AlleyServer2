package com.edu.nju.alley.dao;

import com.edu.nju.alley.po.ArchPO;
import com.edu.nju.alley.po.ArchPicturePO;

public interface ArchDataService {

    ArchPO getArch(Integer archId);

    ArchPicturePO getArchPicture(Integer archId);



}
