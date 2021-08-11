package com.edu.nju.alley.dao.support;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;

public final class UserDSS {

    public static final UserPO userPO = new UserPO();

    public static final SqlColumn<Integer> userId = userPO.userId;

    public static final SqlColumn<String> openId = userPO.openId;

    public static final SqlColumn<String> name = userPO.name;

    public static final SqlColumn<Integer> gender = userPO.gender;

    public static final SqlColumn<String> avatar = userPO.avatar;

    public static final SqlColumn<Boolean> locateAuth = userPO.locateAuth;

    public static final class UserPO extends SqlTable {
        public final SqlColumn<Integer> userId = column("user_id", JDBCType.INTEGER);

        public final SqlColumn<String> openId = column("open_id", JDBCType.VARCHAR);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<Integer> gender = column("gender", JDBCType.INTEGER);

        public final SqlColumn<String> avatar = column("avatar", JDBCType.VARCHAR);

        public final SqlColumn<Boolean> locateAuth = column("locate_auth", JDBCType.BIT);

        public UserPO() {
            super("user_info");
        }
    }

}