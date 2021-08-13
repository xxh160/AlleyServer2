package com.edu.nju.alley.service.impl;

import com.edu.nju.alley.dto.ArchCommentDTO;
import com.edu.nju.alley.service.ArchService;
import com.edu.nju.alley.vo.ArchVO;
import com.edu.nju.alley.vo.CommentVO;
import org.springframework.stereotype.Service;

@Service
public class ArchServiceImpl implements ArchService {
    @Override
    public ArchVO view(Integer archId) {
        return null;
    }

    @Override
    public CommentVO comment(ArchCommentDTO archCommentDTO) {
        return null;
    }

    @Override
    public Object mark(Integer archId, Integer score) {
        return null;
    }
}
