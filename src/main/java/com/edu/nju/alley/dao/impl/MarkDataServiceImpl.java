package com.edu.nju.alley.dao.impl;

import com.edu.nju.alley.dao.MarkDataService;
import com.edu.nju.alley.dao.mapper.MarkMapper;
import com.edu.nju.alley.dao.support.MarkDSS;
import com.edu.nju.alley.po.MarkPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Service
public class MarkDataServiceImpl implements MarkDataService {

    private final MarkMapper markMapper;

    @Autowired
    MarkDataServiceImpl(MarkMapper markMapper){
        this.markMapper=markMapper;
    }

    @Override
    public Object insertMark(Integer archId, Integer score) {


        return null;
    }

    @Override
    public List<MarkPO> getMarks(Integer archId) {
        return markMapper
                .select(c->c.where(MarkDSS.archId,isEqualTo(archId)));
    }
}
