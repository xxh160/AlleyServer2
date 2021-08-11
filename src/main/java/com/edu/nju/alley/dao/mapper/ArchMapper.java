package com.edu.nju.alley.dao.mapper;

import com.edu.nju.alley.po.ArchPO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static com.edu.nju.alley.dao.support.ArchDSS.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface ArchMapper {

    BasicColumn[] selectList = BasicColumn.columnList(archId, name, des, longitude, latitude);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    long count(SelectStatementProvider selectStatement);

    @DeleteProvider(type = SqlProviderAdapter.class, method = "delete")
    int delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type = SqlProviderAdapter.class, method = "insert")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "record.id", before = false, resultType = Integer.class)
    int insert(InsertStatementProvider<ArchPO> insertStatement);

    @InsertProvider(type = SqlProviderAdapter.class, method = "insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<ArchPO> multipleInsertStatement);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(id = "ArchPOResult", value = {
            @Result(column = "arch_id", property = "archId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "des", property = "des", jdbcType = JdbcType.VARCHAR),
            @Result(column = "longitude", property = "longitude", jdbcType = JdbcType.VARCHAR),
            @Result(column = "latitude", property = "latitude", jdbcType = JdbcType.VARCHAR)
    })
    Optional<ArchPO> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultMap("ArchPOResult")
    List<ArchPO> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type = SqlProviderAdapter.class, method = "update")
    int update(UpdateStatementProvider updateStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, archPO, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, archPO, completer);
    }

    default int deleteByPrimaryKey(Integer archId_) {
        return delete(c ->
                c.where(archId, isEqualTo(archId_))
        );
    }

    default int insert(ArchPO record) {
        return MyBatis3Utils.insert(this::insert, record, archPO, c ->
                c.map(archId).toProperty("archId")
                        .map(name).toProperty("name")
                        .map(des).toProperty("des")
                        .map(longitude).toProperty("longitude")
                        .map(latitude).toProperty("latitude")
        );
    }

    default int insertMultiple(Collection<ArchPO> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, archPO, c ->
                c.map(archId).toProperty("archId")
                        .map(name).toProperty("name")
                        .map(des).toProperty("des")
                        .map(longitude).toProperty("longitude")
                        .map(latitude).toProperty("latitude")
        );
    }

    default int insertSelective(ArchPO record) {
        return MyBatis3Utils.insert(this::insert, record, archPO, c ->
                c.map(archId).toPropertyWhenPresent("archId", record::getArchId)
                        .map(name).toPropertyWhenPresent("name", record::getName)
                        .map(des).toPropertyWhenPresent("des", record::getDes)
                        .map(longitude).toPropertyWhenPresent("longitude", record::getLongitude)
                        .map(latitude).toPropertyWhenPresent("latitude", record::getLatitude)
        );
    }

    default Optional<ArchPO> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, archPO, completer);
    }

    default List<ArchPO> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, archPO, completer);
    }

    default List<ArchPO> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, archPO, completer);
    }

    default Optional<ArchPO> selectByPrimaryKey(Integer archId_) {
        return selectOne(c ->
                c.where(archId, isEqualTo(archId_))
        );
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, archPO, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(ArchPO record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(archId).equalTo(record::getArchId)
                .set(name).equalTo(record::getName)
                .set(des).equalTo(record::getDes)
                .set(longitude).equalTo(record::getLongitude)
                .set(latitude).equalTo(record::getLatitude);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(ArchPO record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(archId).equalToWhenPresent(record::getArchId)
                .set(name).equalToWhenPresent(record::getName)
                .set(des).equalToWhenPresent(record::getDes)
                .set(longitude).equalToWhenPresent(record::getLongitude)
                .set(latitude).equalToWhenPresent(record::getLatitude);
    }

    default int updateByPrimaryKey(ArchPO record) {
        return update(c ->
                c.set(name).equalTo(record::getName)
                        .set(des).equalTo(record::getDes)
                        .set(longitude).equalTo(record::getLongitude)
                        .set(latitude).equalTo(record::getLatitude)
                        .where(archId, isEqualTo(record::getArchId))
        );
    }

    default int updateByPrimaryKeySelective(ArchPO record) {
        return update(c ->
                c.set(name).equalToWhenPresent(record::getName)
                        .set(des).equalToWhenPresent(record::getDes)
                        .set(longitude).equalToWhenPresent(record::getLongitude)
                        .set(latitude).equalToWhenPresent(record::getLatitude)
                        .where(archId, isEqualTo(record::getArchId))
        );
    }
}