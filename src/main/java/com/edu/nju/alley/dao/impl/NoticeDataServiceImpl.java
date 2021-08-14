package com.edu.nju.alley.dao.impl;

import com.edu.nju.alley.dao.NoticeDataService;
import com.edu.nju.alley.dao.mapper.NoticeMapper;
import com.edu.nju.alley.dao.support.NoticeDSS;
import com.edu.nju.alley.po.NoticePO;
import org.springframework.stereotype.Service;

import java.util.List;

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
        //注意这里没有检查noticeId对应的notice是否存在
        NoticePO noticePO=noticeMapper.selectByPrimaryKey(noticeId).get();
        noticePO.setIsUnread(true);
        noticeMapper.updateByPrimaryKey(noticePO);
    }

}
