package com.edu.nju.alley.service;

import com.edu.nju.alley.constant.Const;
import com.edu.nju.alley.dto.ArchCommentDTO;
import com.edu.nju.alley.dto.ChildCommentDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CommentServiceTest {

    private final CommentService commentService;

    @Autowired
    public CommentServiceTest(CommentService commentService) {
        this.commentService = commentService;
    }

    private ArchCommentDTO defaultArchCommentDTO() {
        ArchCommentDTO res = new ArchCommentDTO();
        res.setArchId(2);
        res.setContent("哇塞！");
        res.setUserId(2);
        res.setPicture(Const.NullPicUrl.getId());
        return res;
    }

    private ChildCommentDTO defaultChildCommentDTO() {
        ChildCommentDTO child = new ChildCommentDTO();
        child.setArchId(2);
        child.setPicture(Const.NullPicUrl.getId());
        child.setUserId(3);
        child.setFatherId(1);
        child.setContent("哇塞啥子哟。");
        return child;
    }

    @Test
    public void commentArchTest() {
        commentService.commentArch(defaultArchCommentDTO());
    }

    @Test
    public void commentCommentTest() {
        commentService.commentComment(defaultChildCommentDTO());
    }

}
