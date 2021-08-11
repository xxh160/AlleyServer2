package com.edu.nju.alley.dao.support;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;

public final class MarkDSS {

    public static final MarkPO markPO = new MarkPO();

    public static final SqlColumn<Integer> userId = markPO.userId;

    public static final SqlColumn<Integer> archId = markPO.archId;

    public static final SqlColumn<Integer> score = markPO.score;

    public static final class MarkPO extends SqlTable {
        public final SqlColumn<Integer> userId = column("user_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> archId = column("arch_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> score = column("score", JDBCType.INTEGER);

        public MarkPO() {
            super("mark");
        }
    }

}