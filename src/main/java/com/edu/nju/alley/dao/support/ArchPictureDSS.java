package com.edu.nju.alley.dao.support;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;

public final class ArchPictureDSS {

    public static final ArchPicture archPicture = new ArchPicture();

    public static final SqlColumn<Integer> archId = archPicture.archId;

    public static final SqlColumn<String> picture = archPicture.picture;

    public static final class ArchPicture extends SqlTable {
        public final SqlColumn<Integer> archId = column("arch_id", JDBCType.INTEGER);

        public final SqlColumn<String> picture = column("picture", JDBCType.VARCHAR);

        public ArchPicture() {
            super("arch_picture");
        }
    }

}