package com.edu.nju.alley.dao.mapper;

import com.edu.nju.alley.po.NoticePO;
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

import static com.edu.nju.alley.dao.support.NoticeDSS.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface NoticeMapper {

    BasicColumn[] selectList = BasicColumn.columnList(noticeId, senderId, userId, content, isUnread, commentId);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    long count(SelectStatementProvider selectStatement);

    @DeleteProvider(type = SqlProviderAdapter.class, method = "delete")
    int delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type = SqlProviderAdapter.class, method = "insert")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "record.noticeId", before = false, resultType = Integer.class)
    int insert(InsertStatementProvider<NoticePO> insertStatement);

    @InsertProvider(type = SqlProviderAdapter.class, method = "insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<NoticePO> multipleInsertStatement);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(id = "NoticePOResult", value = {
            @Result(column = "notice_id", property = "noticeId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "sender_id", property = "senderId", jdbcType = JdbcType.INTEGER),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.INTEGER),
            @Result(column = "content", property = "content", jdbcType = JdbcType.VARCHAR),
            @Result(column = "is_unread", property = "isUnread", jdbcType = JdbcType.BIT),
            @Result(column = "comment_id", property = "commentId", jdbcType = JdbcType.INTEGER)
    })
    Optional<NoticePO> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultMap("NoticePOResult")
    List<NoticePO> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type = SqlProviderAdapter.class, method = "update")
    int update(UpdateStatementProvider updateStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, noticePO, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, noticePO, completer);
    }

    default int deleteByPrimaryKey(Integer noticeId_) {
        return delete(c ->
                c.where(noticeId, isEqualTo(noticeId_))
        );
    }

    default int insert(NoticePO record) {
        return MyBatis3Utils.insert(this::insert, record, noticePO, c ->
                c.map(noticeId).toProperty("noticeId")
                        .map(senderId).toProperty("senderId")
                        .map(userId).toProperty("userId")
                        .map(content).toProperty("content")
                        .map(isUnread).toProperty("isUnread")
                        .map(commentId).toProperty("commentId")
        );
    }

    default int insertMultiple(Collection<NoticePO> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, noticePO, c ->
                c.map(noticeId).toProperty("noticeId")
                        .map(senderId).toProperty("senderId")
                        .map(userId).toProperty("userId")
                        .map(content).toProperty("content")
                        .map(isUnread).toProperty("isUnread")
                        .map(commentId).toProperty("commentId")
        );
    }

    default int insertSelective(NoticePO record) {
        return MyBatis3Utils.insert(this::insert, record, noticePO, c ->
                c.map(noticeId).toPropertyWhenPresent("noticeId", record::getNoticeId)
                        .map(senderId).toPropertyWhenPresent("senderId", record::getSenderId)
                        .map(userId).toPropertyWhenPresent("userId", record::getUserId)
                        .map(content).toPropertyWhenPresent("content", record::getContent)
                        .map(isUnread).toPropertyWhenPresent("isUnread", record::getIsUnread)
                        .map(commentId).toPropertyWhenPresent("commentId", record::getCommentId)
        );
    }

    default Optional<NoticePO> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, noticePO, completer);
    }

    default List<NoticePO> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, noticePO, completer);
    }

    default List<NoticePO> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, noticePO, completer);
    }

    default Optional<NoticePO> selectByPrimaryKey(Integer noticeId_) {
        return selectOne(c ->
                c.where(noticeId, isEqualTo(noticeId_))
        );
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, noticePO, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(NoticePO record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(noticeId).equalTo(record::getNoticeId)
                .set(senderId).equalTo(record::getSenderId)
                .set(userId).equalTo(record::getUserId)
                .set(content).equalTo(record::getContent)
                .set(isUnread).equalTo(record::getIsUnread)
                .set(commentId).equalTo(record::getCommentId);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(NoticePO record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(noticeId).equalToWhenPresent(record::getNoticeId)
                .set(senderId).equalToWhenPresent(record::getSenderId)
                .set(userId).equalToWhenPresent(record::getUserId)
                .set(content).equalToWhenPresent(record::getContent)
                .set(isUnread).equalToWhenPresent(record::getIsUnread)
                .set(commentId).equalToWhenPresent(record::getCommentId);
    }

    default int updateByPrimaryKey(NoticePO record) {
        return update(c ->
                c.set(senderId).equalTo(record::getSenderId)
                        .set(userId).equalTo(record::getUserId)
                        .set(content).equalTo(record::getContent)
                        .set(isUnread).equalTo(record::getIsUnread)
                        .set(commentId).equalTo(record::getCommentId)
                        .where(noticeId, isEqualTo(record::getNoticeId))
        );
    }

    default int updateByPrimaryKeySelective(NoticePO record) {
        return update(c ->
                c.set(senderId).equalToWhenPresent(record::getSenderId)
                        .set(userId).equalToWhenPresent(record::getUserId)
                        .set(content).equalToWhenPresent(record::getContent)
                        .set(isUnread).equalToWhenPresent(record::getIsUnread)
                        .set(commentId).equalToWhenPresent(record::getCommentId)
                        .where(noticeId, isEqualTo(record::getNoticeId))
        );
    }
}