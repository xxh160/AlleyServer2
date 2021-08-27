package com.edu.nju.alley.dao.impl;

import com.edu.nju.alley.constant.ReturnMessage;
import com.edu.nju.alley.dao.NoticeDataService;
import com.edu.nju.alley.dao.mapper.NoticeMapper;
import com.edu.nju.alley.dao.support.NoticeDSS;
import com.edu.nju.alley.exp.NoSuchDataException;
import com.edu.nju.alley.po.NoticePO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Service
public class NoticeDataServiceImpl implements NoticeDataService {

    private final NoticeMapper noticeMapper;

    public NoticeDataServiceImpl(NoticeMapper noticeMapper) {
        this.noticeMapper = noticeMapper;
    }

    @Override
    public List<NoticePO> getUserNotices(Integer userId) {
        return noticeMapper
                .select(c -> c.where(NoticeDSS.userId, isEqualTo(userId)));
    }

    @Override
    public void read(Integer noticeId) {
        Optional<NoticePO> optional = noticeMapper.selectByPrimaryKey(noticeId);
        if (optional.isEmpty()) throw new NoSuchDataException(ReturnMessage.NoSuchNoticeExp.getMsg());
        NoticePO noticePO = optional.get();
        noticePO.setIsUnread(false);
        noticeMapper.updateByPrimaryKey(noticePO);
    }

    @Override
    public void insertNotice(NoticePO notice) {
        noticeMapper.insert(notice);
    }

}
