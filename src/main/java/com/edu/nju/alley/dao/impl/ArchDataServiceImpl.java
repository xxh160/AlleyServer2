package com.edu.nju.alley.dao.impl;

import com.edu.nju.alley.dao.ArchDataService;
import com.edu.nju.alley.dao.mapper.ArchMapper;
import com.edu.nju.alley.dao.mapper.ArchPictureMapper;
import com.edu.nju.alley.dao.support.ArchPictureDSS;
import com.edu.nju.alley.po.ArchPO;
import com.edu.nju.alley.po.ArchPicturePO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Service
public class ArchDataServiceImpl implements ArchDataService {

    private final ArchMapper archMapper;

    private final ArchPictureMapper archPictureMapper;

    @Autowired
    public ArchDataServiceImpl(ArchMapper archMapper,ArchPictureMapper archPictureMapper){
        this.archMapper=archMapper;
        this.archPictureMapper=archPictureMapper;
    }

    @Override
    public ArchPO getArch(Integer archId) {
        Optional<ArchPO> archOptional=archMapper.selectByPrimaryKey(archId);
        return archOptional.orElse(null);//是这样写的吗？？我也不太清楚，hwd你看看
    }

    @Override
    public ArchPicturePO getArchPicture(Integer archId) {
        Optional<ArchPicturePO> archPictureOptional=archPictureMapper.selectOne(c->c.where(ArchPictureDSS.archId,isEqualTo(archId)));
        return archPictureOptional.orElse(null);//好的这个我也不太清楚，总之是返回ArchPicturePO
    }
}
