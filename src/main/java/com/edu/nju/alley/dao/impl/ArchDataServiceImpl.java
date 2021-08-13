package com.edu.nju.alley.dao.impl;

import com.edu.nju.alley.dao.ArchDataService;
import com.edu.nju.alley.dao.mapper.ArchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArchDataServiceImpl implements ArchDataService {

    private final ArchMapper archMapper;

    @Autowired
    public ArchDataServiceImpl(ArchMapper archMapper){
        this.archMapper=archMapper;
    }
}
