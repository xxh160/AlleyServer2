package com.edu.nju.alley.dao.mapper;

import com.edu.nju.alley.po.UserPO;
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

import static com.edu.nju.alley.dao.support.UserDSS.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface UserMapper {

    BasicColumn[] selectList = BasicColumn.columnList(userId, openId, name, gender, avatar, locateAuth);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    long count(SelectStatementProvider selectStatement);

    @DeleteProvider(type = SqlProviderAdapter.class, method = "delete")
    int delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type = SqlProviderAdapter.class, method = "insert")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "record.userId", before = false, resultType = Integer.class)
    int insert(InsertStatementProvider<UserPO> insertStatement);

    @InsertProvider(type = SqlProviderAdapter.class, method = "insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<UserPO> multipleInsertStatement);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(id = "UserPOResult", value = {
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "open_id", property = "openId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "gender", property = "gender", jdbcType = JdbcType.INTEGER),
            @Result(column = "avatar", property = "avatar", jdbcType = JdbcType.VARCHAR),
            @Result(column = "locate_auth", property = "locateAuth", jdbcType = JdbcType.BIT)
    })
    Optional<UserPO> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultMap("UserPOResult")
    List<UserPO> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type = SqlProviderAdapter.class, method = "update")
    int update(UpdateStatementProvider updateStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, userPO, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, userPO, completer);
    }

    default int deleteByPrimaryKey(Integer userId_) {
        return delete(c ->
                c.where(userId, isEqualTo(userId_))
        );
    }

    default int insert(UserPO record) {
        return MyBatis3Utils.insert(this::insert, record, userPO, c ->
                c.map(userId).toProperty("userId")
                        .map(openId).toProperty("openId")
                        .map(name).toProperty("name")
                        .map(gender).toProperty("gender")
                        .map(avatar).toProperty("avatar")
                        .map(locateAuth).toProperty("locateAuth")
        );
    }

    default int insertMultiple(Collection<UserPO> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, userPO, c ->
                c.map(userId).toProperty("userId")
                        .map(openId).toProperty("openId")
                        .map(name).toProperty("name")
                        .map(gender).toProperty("gender")
                        .map(avatar).toProperty("avatar")
                        .map(locateAuth).toProperty("locateAuth")
        );
    }

    default int insertSelective(UserPO record) {
        return MyBatis3Utils.insert(this::insert, record, userPO, c ->
                c.map(userId).toPropertyWhenPresent("userId", record::getUserId)
                        .map(openId).toPropertyWhenPresent("openId", record::getOpenId)
                        .map(name).toPropertyWhenPresent("name", record::getName)
                        .map(gender).toPropertyWhenPresent("gender", record::getGender)
                        .map(avatar).toPropertyWhenPresent("avatar", record::getAvatar)
                        .map(locateAuth).toPropertyWhenPresent("locateAuth", record::getLocateAuth)
        );
    }

    default Optional<UserPO> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, userPO, completer);
    }

    default List<UserPO> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, userPO, completer);
    }

    default List<UserPO> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, userPO, completer);
    }

    default Optional<UserPO> selectByPrimaryKey(Integer userId_) {
        return selectOne(c ->
                c.where(userId, isEqualTo(userId_))
        );
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, userPO, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(UserPO record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(userId).equalTo(record::getUserId)
                .set(openId).equalTo(record::getOpenId)
                .set(name).equalTo(record::getName)
                .set(gender).equalTo(record::getGender)
                .set(avatar).equalTo(record::getAvatar)
                .set(locateAuth).equalTo(record::getLocateAuth);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(UserPO record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(userId).equalToWhenPresent(record::getUserId)
                .set(openId).equalToWhenPresent(record::getOpenId)
                .set(name).equalToWhenPresent(record::getName)
                .set(gender).equalToWhenPresent(record::getGender)
                .set(avatar).equalToWhenPresent(record::getAvatar)
                .set(locateAuth).equalToWhenPresent(record::getLocateAuth);
    }

    default int updateByPrimaryKey(UserPO record) {
        return update(c ->
                c.set(openId).equalTo(record::getOpenId)
                        .set(name).equalTo(record::getName)
                        .set(gender).equalTo(record::getGender)
                        .set(avatar).equalTo(record::getAvatar)
                        .set(locateAuth).equalTo(record::getLocateAuth)
                        .where(userId, isEqualTo(record::getUserId))
        );
    }

    default int updateByPrimaryKeySelective(UserPO record) {
        return update(c ->
                c.set(openId).equalToWhenPresent(record::getOpenId)
                        .set(name).equalToWhenPresent(record::getName)
                        .set(gender).equalToWhenPresent(record::getGender)
                        .set(avatar).equalToWhenPresent(record::getAvatar)
                        .set(locateAuth).equalToWhenPresent(record::getLocateAuth)
                        .where(userId, isEqualTo(record::getUserId))
        );
    }
}