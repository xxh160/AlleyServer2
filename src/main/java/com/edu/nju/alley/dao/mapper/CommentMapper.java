package com.edu.nju.alley.dao.mapper;

import com.edu.nju.alley.po.CommentPO;
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

import javax.annotation.Generated;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static com.edu.nju.alley.dao.support.CommentDSS.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface CommentMapper {

    BasicColumn[] selectList = BasicColumn.columnList(commentId, archId, userId, fatherId, content, likeNum, createT, picture);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    long count(SelectStatementProvider selectStatement);

    @DeleteProvider(type = SqlProviderAdapter.class, method = "delete")
    int delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type = SqlProviderAdapter.class, method = "insert")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "record.id", before = false, resultType = Integer.class)
    int insert(InsertStatementProvider<CommentPO> insertStatement);

    @InsertProvider(type = SqlProviderAdapter.class, method = "insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<CommentPO> multipleInsertStatement);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(id = "CommentPOResult", value = {
            @Result(column = "comment_id", property = "commentId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "arch_id", property = "archId", jdbcType = JdbcType.INTEGER),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.INTEGER),
            @Result(column = "father_id", property = "fatherId", jdbcType = JdbcType.INTEGER),
            @Result(column = "content", property = "content", jdbcType = JdbcType.INTEGER),
            @Result(column = "like_num", property = "likeNum", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_t", property = "createT", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "picture", property = "picture", jdbcType = JdbcType.VARCHAR)
    })
    Optional<CommentPO> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultMap("CommentPOResult")
    List<CommentPO> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type = SqlProviderAdapter.class, method = "update")
    int update(UpdateStatementProvider updateStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, commentPO, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, commentPO, completer);
    }

    default int deleteByPrimaryKey(Integer commentId_) {
        return delete(c ->
                c.where(commentId, isEqualTo(commentId_))
        );
    }

    default int insert(CommentPO record) {
        return MyBatis3Utils.insert(this::insert, record, commentPO, c ->
                c.map(commentId).toProperty("commentId")
                        .map(archId).toProperty("archId")
                        .map(userId).toProperty("userId")
                        .map(fatherId).toProperty("fatherId")
                        .map(content).toProperty("content")
                        .map(likeNum).toProperty("likeNum")
                        .map(createT).toProperty("createT")
                        .map(picture).toProperty("picture")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<CommentPO> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, commentPO, c ->
                c.map(commentId).toProperty("commentId")
                        .map(archId).toProperty("archId")
                        .map(userId).toProperty("userId")
                        .map(fatherId).toProperty("fatherId")
                        .map(content).toProperty("content")
                        .map(likeNum).toProperty("likeNum")
                        .map(createT).toProperty("createT")
                        .map(picture).toProperty("picture")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(CommentPO record) {
        return MyBatis3Utils.insert(this::insert, record, commentPO, c ->
                c.map(commentId).toPropertyWhenPresent("commentId", record::getCommentId)
                        .map(archId).toPropertyWhenPresent("archId", record::getArchId)
                        .map(userId).toPropertyWhenPresent("userId", record::getUserId)
                        .map(fatherId).toPropertyWhenPresent("fatherId", record::getFatherId)
                        .map(content).toPropertyWhenPresent("content", record::getContent)
                        .map(likeNum).toPropertyWhenPresent("likeNum", record::getLikeNum)
                        .map(createT).toPropertyWhenPresent("createT", record::getCreateT)
                        .map(picture).toPropertyWhenPresent("picture", record::getPicture)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<CommentPO> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, commentPO, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<CommentPO> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, commentPO, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<CommentPO> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, commentPO, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<CommentPO> selectByPrimaryKey(Integer commentId_) {
        return selectOne(c ->
                c.where(commentId, isEqualTo(commentId_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, commentPO, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(CommentPO record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(commentId).equalTo(record::getCommentId)
                .set(archId).equalTo(record::getArchId)
                .set(userId).equalTo(record::getUserId)
                .set(fatherId).equalTo(record::getFatherId)
                .set(content).equalTo(record::getContent)
                .set(likeNum).equalTo(record::getLikeNum)
                .set(createT).equalTo(record::getCreateT)
                .set(picture).equalTo(record::getPicture);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(CommentPO record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(commentId).equalToWhenPresent(record::getCommentId)
                .set(archId).equalToWhenPresent(record::getArchId)
                .set(userId).equalToWhenPresent(record::getUserId)
                .set(fatherId).equalToWhenPresent(record::getFatherId)
                .set(content).equalToWhenPresent(record::getContent)
                .set(likeNum).equalToWhenPresent(record::getLikeNum)
                .set(createT).equalToWhenPresent(record::getCreateT)
                .set(picture).equalToWhenPresent(record::getPicture);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(CommentPO record) {
        return update(c ->
                c.set(archId).equalTo(record::getArchId)
                        .set(userId).equalTo(record::getUserId)
                        .set(fatherId).equalTo(record::getFatherId)
                        .set(content).equalTo(record::getContent)
                        .set(likeNum).equalTo(record::getLikeNum)
                        .set(createT).equalTo(record::getCreateT)
                        .set(picture).equalTo(record::getPicture)
                        .where(commentId, isEqualTo(record::getCommentId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(CommentPO record) {
        return update(c ->
                c.set(archId).equalToWhenPresent(record::getArchId)
                        .set(userId).equalToWhenPresent(record::getUserId)
                        .set(fatherId).equalToWhenPresent(record::getFatherId)
                        .set(content).equalToWhenPresent(record::getContent)
                        .set(likeNum).equalToWhenPresent(record::getLikeNum)
                        .set(createT).equalToWhenPresent(record::getCreateT)
                        .set(picture).equalToWhenPresent(record::getPicture)
                        .where(commentId, isEqualTo(record::getCommentId))
        );
    }
}