package com.edu.nju.alley.dao.mapper;

import com.edu.nju.alley.po.MarkPO;
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

import static com.edu.nju.alley.dao.support.MarkDSS.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface MarkMapper {

    BasicColumn[] selectList = BasicColumn.columnList(userId, archId, score);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    long count(SelectStatementProvider selectStatement);

    @DeleteProvider(type = SqlProviderAdapter.class, method = "delete")
    int delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type = SqlProviderAdapter.class, method = "insert")
    int insert(InsertStatementProvider<MarkPO> insertStatement);

    @InsertProvider(type = SqlProviderAdapter.class, method = "insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<MarkPO> multipleInsertStatement);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(id = "MarkPOResult", value = {
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "arch_id", property = "archId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "score", property = "score", jdbcType = JdbcType.INTEGER)
    })
    Optional<MarkPO> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultMap("MarkPOResult")
    List<MarkPO> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type = SqlProviderAdapter.class, method = "update")
    int update(UpdateStatementProvider updateStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, markPO, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, markPO, completer);
    }

    default int deleteByPrimaryKey(Integer userId_, Integer archId_) {
        return delete(c ->
                c.where(userId, isEqualTo(userId_))
                        .and(archId, isEqualTo(archId_))
        );
    }

    default int insert(MarkPO record) {
        return MyBatis3Utils.insert(this::insert, record, markPO, c ->
                c.map(userId).toProperty("userId")
                        .map(archId).toProperty("archId")
                        .map(score).toProperty("score")
        );
    }

    default int insertMultiple(Collection<MarkPO> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, markPO, c ->
                c.map(userId).toProperty("userId")
                        .map(archId).toProperty("archId")
                        .map(score).toProperty("score")
        );
    }

    default int insertSelective(MarkPO record) {
        return MyBatis3Utils.insert(this::insert, record, markPO, c ->
                c.map(userId).toPropertyWhenPresent("userId", record::getUserId)
                        .map(archId).toPropertyWhenPresent("archId", record::getArchId)
                        .map(score).toPropertyWhenPresent("score", record::getScore)
        );
    }

    default Optional<MarkPO> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, markPO, completer);
    }

    default List<MarkPO> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, markPO, completer);
    }

    default List<MarkPO> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, markPO, completer);
    }

    default Optional<MarkPO> selectByPrimaryKey(Integer userId_, Integer archId_) {
        return selectOne(c ->
                c.where(userId, isEqualTo(userId_))
                        .and(archId, isEqualTo(archId_))
        );
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, markPO, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(MarkPO record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(userId).equalTo(record::getUserId)
                .set(archId).equalTo(record::getArchId)
                .set(score).equalTo(record::getScore);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(MarkPO record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(userId).equalToWhenPresent(record::getUserId)
                .set(archId).equalToWhenPresent(record::getArchId)
                .set(score).equalToWhenPresent(record::getScore);
    }

    default int updateByPrimaryKey(MarkPO record) {
        return update(c ->
                c.set(score).equalTo(record::getScore)
                        .where(userId, isEqualTo(record::getUserId))
                        .and(archId, isEqualTo(record::getArchId))
        );
    }

    default int updateByPrimaryKeySelective(MarkPO record) {
        return update(c ->
                c.set(score).equalToWhenPresent(record::getScore)
                        .where(userId, isEqualTo(record::getUserId))
                        .and(archId, isEqualTo(record::getArchId))
        );
    }
}