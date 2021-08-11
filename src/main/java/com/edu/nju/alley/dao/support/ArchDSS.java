package com.edu.nju.alley.dao.support;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;

public final class ArchDSS {

    public static final ArchPO archPO = new ArchPO();

    public static final SqlColumn<Integer> archId = archPO.archId;

    public static final SqlColumn<String> name = archPO.name;

    public static final SqlColumn<String> des = archPO.des;

    public static final SqlColumn<String> longitude = archPO.longitude;

    public static final SqlColumn<String> latitude = archPO.latitude;

    public static final class ArchPO extends SqlTable {
        public final SqlColumn<Integer> archId = column("arch_id", JDBCType.INTEGER);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<String> des = column("des", JDBCType.VARCHAR);

        public final SqlColumn<String> longitude = column("longitude", JDBCType.VARCHAR);

        public final SqlColumn<String> latitude = column("latitude", JDBCType.VARCHAR);

        public ArchPO() {
            super("arch");
        }
    }

}