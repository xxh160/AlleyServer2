package com.edu.nju.alley.service.impl;

import com.edu.nju.alley.dao.ArchDataService;
import com.edu.nju.alley.dao.MarkDataService;
import com.edu.nju.alley.dto.ArchCommentDTO;
import com.edu.nju.alley.po.ArchPO;
import com.edu.nju.alley.po.ArchPicturePO;
import com.edu.nju.alley.po.MarkPO;
import com.edu.nju.alley.service.ArchService;
import com.edu.nju.alley.service.CommentService;
import com.edu.nju.alley.vo.ArchVO;
import com.edu.nju.alley.vo.CommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArchServiceImpl implements ArchService {

    private final ArchDataService archDataService;

    private final MarkDataService markDataService;

    private final CommentService commentService;

    @Autowired
    public ArchServiceImpl(ArchDataService archDataService, MarkDataService markDataService, CommentService commentService) {
        this.archDataService = archDataService;
        this.markDataService = markDataService;
        this.commentService = commentService;
    }

    //查看建筑信息
    @Override
    public ArchVO view(Integer archId) {
        //得到Arch基本信息
        //得到Arch的评论
        //得到Arch的图片
        //得到Arch的评分
        //生成ArchVO并返回

        //得到Arch基本信息
        ArchPO archPO = archDataService.getArch(archId);

        // 得到Arch的评论
        List<CommentVO> commentVOS = commentService.archComments(archId);

        // 得到Arch的图片
        List<ArchPicturePO> archPicturePOS = archDataService.getArchPicture(archId);

        // 得到Arch的图片
        List<String> picturePaths = archPicturePOS.stream()
                .map(ArchPicturePO::getPicture)
                .collect(Collectors.toList());

        // 得到Arch的评分
        List<MarkPO> markPOS = markDataService.getMarks(archId);

        // 评分记录的数量
        int length = markPOS.size();

        // 平均分
        double score = 0;

        // 计算平均分
        for (MarkPO mark : markPOS) {
            score += mark.getScore();
        }

        score /= length;

        // 想个办法把他们组合起来
        return ArchVO.buildVO(archPO, score, picturePaths, commentVOS);
    }

    //评论建筑
    @Override
    public CommentVO comment(ArchCommentDTO archCommentDTO) {
        // 向CommentPO中插入新的PO
        // 返回相应的VO
        return null;
    }

    // 对建筑评分
    @Override
    public void mark(Integer archId, Integer score, Integer userId) {
        // 向MarkPO中插入新的PO
        // 无返回
        // TODO: markDataService 得改一下
        markDataService.insertMark(archId, score);
    }

}
