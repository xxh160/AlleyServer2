package com.edu.nju.alley.dao.mapper;

import com.edu.nju.alley.po.LikePO;
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

import static com.edu.nju.alley.dao.support.LikeDSS.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface LikeMapper {

    BasicColumn[] selectList = BasicColumn.columnList(userId, commentId);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    long count(SelectStatementProvider selectStatement);

    @DeleteProvider(type = SqlProviderAdapter.class, method = "delete")
    int delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type = SqlProviderAdapter.class, method = "insert")
    int insert(InsertStatementProvider<LikePO> insertStatement);

    @InsertProvider(type = SqlProviderAdapter.class, method = "insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<LikePO> multipleInsertStatement);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(id = "LikePOResult", value = {
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "comment_id", property = "commentId", jdbcType = JdbcType.INTEGER, id = true)
    })
    Optional<LikePO> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultMap("LikePOResult")
    List<LikePO> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type = SqlProviderAdapter.class, method = "update")
    int update(UpdateStatementProvider updateStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, likePO, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, likePO, completer);
    }

    default int deleteByPrimaryKey(Integer userId_, Integer commentId_) {
        return delete(c ->
                c.where(userId, isEqualTo(userId_))
                        .and(commentId, isEqualTo(commentId_))
        );
    }

    default int insert(LikePO record) {
        return MyBatis3Utils.insert(this::insert, record, likePO, c ->
                c.map(userId).toProperty("userId")
                        .map(commentId).toProperty("commentId")
        );
    }

    default int insertMultiple(Collection<LikePO> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, likePO, c ->
                c.map(userId).toProperty("userId")
                        .map(commentId).toProperty("commentId")
        );
    }

    default int insertSelective(LikePO record) {
        return MyBatis3Utils.insert(this::insert, record, likePO, c ->
                c.map(userId).toPropertyWhenPresent("userId", record::getUserId)
                        .map(commentId).toPropertyWhenPresent("commentId", record::getCommentId)
        );
    }

    default Optional<LikePO> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, likePO, completer);
    }

    default List<LikePO> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, likePO, completer);
    }

    default List<LikePO> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, likePO, completer);
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, likePO, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(LikePO record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(userId).equalTo(record::getUserId)
                .set(commentId).equalTo(record::getCommentId);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(LikePO record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(userId).equalToWhenPresent(record::getUserId)
                .set(commentId).equalToWhenPresent(record::getCommentId);
    }
}