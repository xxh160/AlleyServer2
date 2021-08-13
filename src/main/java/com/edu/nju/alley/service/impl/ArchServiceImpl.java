package com.edu.nju.alley.service.impl;

import com.edu.nju.alley.dao.ArchDataService;
import com.edu.nju.alley.dao.MarkDataService;
import com.edu.nju.alley.dto.ArchCommentDTO;
import com.edu.nju.alley.service.ArchService;
import com.edu.nju.alley.vo.ArchVO;
import com.edu.nju.alley.vo.CommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArchServiceImpl implements ArchService {

    private final ArchDataService archDataService;

    private final MarkDataService markDataService;

    @Autowired
    public ArchServiceImpl(ArchDataService archDataService,MarkDataService markDataService){
        this.archDataService=archDataService;
        this.markDataService=markDataService;
    }

    //查看建筑信息
    @Override
    public ArchVO view(Integer archId) {

        return null;
    }

    //评论建筑
    @Override
    public CommentVO comment(ArchCommentDTO archCommentDTO) {
        return null;
    }

    //对建筑评分
    @Override
    public Object mark(Integer archId, Integer score) {
        return null;
    }
}
