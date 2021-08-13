package com.edu.nju.alley.dao.impl;

import com.edu.nju.alley.dao.MarkDataService;
import com.edu.nju.alley.dao.mapper.MarkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
