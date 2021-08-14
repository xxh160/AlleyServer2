package com.edu.nju.alley.dao.support;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;
import java.util.Date;

public final class CommentDSS {

    public static final CommentPO commentPO = new CommentPO();

    public static final SqlColumn<Integer> commentId = commentPO.commentId;

    public static final SqlColumn<Integer> archId = commentPO.archId;

    public static final SqlColumn<Integer> userId = commentPO.userId;

    public static final SqlColumn<Integer> fatherId = commentPO.fatherId;

    public static final SqlColumn<String> content = commentPO.content;

    public static final SqlColumn<Integer> likeNum = commentPO.likeNum;

    public static final SqlColumn<Date> createT = commentPO.createT;

    public static final SqlColumn<String> picture = commentPO.picture;

    public static final class CommentPO extends SqlTable {
        public final SqlColumn<Integer> commentId = column("comment_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> archId = column("arch_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> userId = column("user_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> fatherId = column("father_id", JDBCType.INTEGER);

        public final SqlColumn<String> content = column("content", JDBCType.VARCHAR);

        public final SqlColumn<Integer> likeNum = column("like_num", JDBCType.INTEGER);

        public final SqlColumn<Date> createT = column("create_t", JDBCType.TIMESTAMP);

        public final SqlColumn<String> picture = column("picture", JDBCType.VARCHAR);

        public CommentPO() {
            super("comment");
        }
    }

}