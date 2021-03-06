
package com.ly.zmn48644.mybatis.session;


import com.ly.zmn48644.mybatis.cursor.Cursor;
import com.ly.zmn48644.mybatis.executor.BatchResult;

import java.io.Closeable;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 * 此接口是MyBatis的业务逻辑核心接口
 * 此接口定义了MyBatis的核心功能
 * 此接口的实现类是 DefaultSqlSession
 * 此接口是从业务层面分析的入口
 * <p>
 * 提供了两种执行SQL语句的方式
 * 第一种 通过namespace+statementId标识,比如  selectOne,selectList等方法
 * 第二种 通过获取mapper接口的方式,这种方式是比较推荐的
 */
public interface SqlSession extends Closeable {


    <T> T selectOne(String statement);

    <T> T selectOne(String statement, Object parameter);

    <E> List<E> selectList(String statement);

    <E> List<E> selectList(String statement, Object parameter);

    <E> List<E> selectList(String statement, Object parameter, RowBounds rowBounds);

    <K, V> Map<K, V> selectMap(String statement, String mapKey);

    <K, V> Map<K, V> selectMap(String statement, Object parameter, String mapKey);

    <K, V> Map<K, V> selectMap(String statement, Object parameter, String mapKey, RowBounds rowBounds);


    <T> Cursor<T> selectCursor(String statement);


    <T> Cursor<T> selectCursor(String statement, Object parameter);

    <T> Cursor<T> selectCursor(String statement, Object parameter, RowBounds rowBounds);


    void select(String statement, Object parameter, ResultHandler handler);


    void select(String statement, ResultHandler handler);


    void select(String statement, Object parameter, RowBounds rowBounds, ResultHandler handler);

    int insert(String statement);


    int insert(String statement, Object parameter);

    int update(String statement);

    int update(String statement, Object parameter);

    int delete(String statement);

    int delete(String statement, Object parameter);

    void commit();

    void commit(boolean force);

    void rollback();

    void rollback(boolean force);

    List<BatchResult> flushStatements();

    @Override
    void close();

    void clearCache();


    Configuration getConfiguration();


    <T> T getMapper(Class<T> type);

    /**
     * 获取内部的数据库连接对象
     *
     * @return
     */
    Connection getConnection();
}
