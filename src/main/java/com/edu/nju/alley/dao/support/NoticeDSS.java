package com.edu.nju.alley.dao.support;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;

public final class NoticeDSS {

    public static final NoticePO noticePO = new NoticePO();

    public static final SqlColumn<Integer> noticeId = noticePO.noticeId;

    public static final SqlColumn<Integer> senderId = noticePO.senderId;

    public static final SqlColumn<Integer> userId = noticePO.userId;

    public static final SqlColumn<String> content = noticePO.content;

    public static final SqlColumn<Boolean> isUnread = noticePO.isUnread;

    public static final SqlColumn<Integer> commentId = noticePO.commentId;

    public static final class NoticePO extends SqlTable {
        public final SqlColumn<Integer> noticeId = column("notice_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> senderId = column("sender_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> userId = column("user_id", JDBCType.INTEGER);

        public final SqlColumn<String> content = column("content", JDBCType.VARCHAR);

        public final SqlColumn<Boolean> isUnread = column("is_unread", JDBCType.BIT);

        public final SqlColumn<Integer> commentId = column("comment_id", JDBCType.INTEGER);

        public NoticePO() {
            super("notice");
        }
    }

}
