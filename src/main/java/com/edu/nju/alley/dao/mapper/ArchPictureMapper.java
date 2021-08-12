package com.edu.nju.alley.dao.mapper;

import com.edu.nju.alley.po.ArchPicturePO;
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

import static com.edu.nju.alley.dao.support.ArchPictureDSS.*;

@Mapper
public interface ArchPictureMapper {

    BasicColumn[] selectList = BasicColumn.columnList(archId, picture);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    long count(SelectStatementProvider selectStatement);

    @DeleteProvider(type = SqlProviderAdapter.class, method = "delete")
    int delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type = SqlProviderAdapter.class, method = "insert")
    int insert(InsertStatementProvider<ArchPicturePO> insertStatement);

    @InsertProvider(type = SqlProviderAdapter.class, method = "insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<ArchPicturePO> multipleInsertStatement);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(id = "ArchPictureResult", value = {
            @Result(column = "arch_id", property = "archId", jdbcType = JdbcType.INTEGER),
            @Result(column = "picture", property = "picture", jdbcType = JdbcType.VARCHAR)
    })
    Optional<ArchPicturePO> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultMap("ArchPictureResult")
    List<ArchPicturePO> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type = SqlProviderAdapter.class, method = "update")
    int update(UpdateStatementProvider updateStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, archPicture, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, archPicture, completer);
    }

    default int insert(ArchPicturePO record) {
        return MyBatis3Utils.insert(this::insert, record, archPicture, c ->
                c.map(archId).toProperty("archId")
                        .map(picture).toProperty("picture")
        );
    }

    default int insertMultiple(Collection<ArchPicturePO> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, archPicture, c ->
                c.map(archId).toProperty("archId")
                        .map(picture).toProperty("picture")
        );
    }

    default int insertSelective(ArchPicturePO record) {
        return MyBatis3Utils.insert(this::insert, record, archPicture, c ->
                c.map(archId).toPropertyWhenPresent("archId", record::getArchId)
                        .map(picture).toPropertyWhenPresent("picture", record::getPicture)
        );
    }

    default Optional<ArchPicturePO> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, archPicture, completer);
    }

    default List<ArchPicturePO> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, archPicture, completer);
    }

    default List<ArchPicturePO> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, archPicture, completer);
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, archPicture, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(ArchPicturePO record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(archId).equalTo(record::getArchId)
                .set(picture).equalTo(record::getPicture);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(ArchPicturePO record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(archId).equalToWhenPresent(record::getArchId)
                .set(picture).equalToWhenPresent(record::getPicture);
    }
    
}