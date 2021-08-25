package com.edu.nju.alley.dao.support;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;

public final class LikeDSS {

    public static final LikePO likePO = new LikePO();

    public static final SqlColumn<Integer> userId = likePO.userId;

    public static final SqlColumn<Integer> commentId = likePO.commentId;

    public static final class LikePO extends SqlTable {
        public final SqlColumn<Integer> userId = column("user_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> commentId = column("comment_id", JDBCType.INTEGER);

        public LikePO() {
            super("like_info");
        }
    }

}