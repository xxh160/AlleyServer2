package com.edu.nju.alley.service.impl;

import com.edu.nju.alley.dao.ArchDataService;
import com.edu.nju.alley.dao.MarkDataService;
import com.edu.nju.alley.po.ArchPO;
import com.edu.nju.alley.po.ArchPicturePO;
import com.edu.nju.alley.po.MarkPO;
import com.edu.nju.alley.service.ArchService;
import com.edu.nju.alley.service.CommentService;
import com.edu.nju.alley.util.DoubleUtil;
import com.edu.nju.alley.vo.ArchVO;
import com.edu.nju.alley.vo.ArchViewVO;
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
    public ArchServiceImpl(ArchDataService archDataService,
                           MarkDataService markDataService,
                           CommentService commentService) {
        this.archDataService = archDataService;
        this.markDataService = markDataService;
        this.commentService = commentService;
    }

    /**
     * 查看建筑信息
     *
     * @param archId 建筑 id
     * @return 建筑信息
     */
    @Override
    public ArchVO view(Integer archId) {
        // 得到 Arch 基本信息
        ArchPO archPO = archDataService.getArch(archId);
        // 得到 Arch 的评论
        List<CommentVO> archComments = commentService.archComments(archId);
        // 得到 Arch 的图片 url
        List<String> picturePaths = archDataService
                .getArchPicture(archId)
                .stream()
                .map(ArchPicturePO::getPicture)
                .collect(Collectors.toList());
        // 得到Arch的评分
        List<MarkPO> marks = markDataService.getMarks(archId);
        Double sum = marks
                .stream()
                .map(MarkPO::getScore)
                .map(Integer::doubleValue)
                .reduce(0.0, Double::sum);
        return ArchVO.buildVO(archPO,
                DoubleUtil.format(sum / marks.size(), 2),
                picturePaths,
                archComments);
    }

    /**
     * 对建筑评分
     *
     * @param archId 建筑 id
     * @param score  分数 1-5
     * @param userId 评分者用户 id
     */
    @Override
    public void mark(Integer archId, Integer score, Integer userId) {
        markDataService.insertMark(archId, score, userId);
    }

    /**
     * 获取全部建筑信息
     *
     * @return 建筑信息列表
     */
    @Override
    public List<ArchViewVO> all() {
        return archDataService.getAll()
                .stream()
                .map(ArchViewVO::new)
                .collect(Collectors.toList());
    }

}
