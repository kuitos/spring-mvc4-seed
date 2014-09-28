package com.kuitos.common.base;

import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Mybatis的操作类
 *
 * @author songbo.cai
 * @since 1.0.0 2012-07-28
 */
public class MybatisDao extends SqlSessionDaoSupport {

    private static final Logger logger = LoggerFactory.getLogger(MybatisDao.class);

    /**
     * 根据Key以及传入参数，进行数据库操作，包括增删改
     *
     * @param key       xml文件中sql的唯一标识，命名空间+ID
     * @param parameter 和xml的key值对应语句的参数
     */
    public void save(String key, Object parameter) {
        if (logger.isDebugEnabled()) {
            getExecuteSql(key, parameter);
        }
        getSqlSession().update(key, parameter);
    }

    /**
     * 根据Key以及传入参数，获取返回类型对应数据
     *
     * @param key       xml文件中sql的唯一标识，命名空间+ID
     * @param parameter 和xml的key值对应语句的参数
     */
    @SuppressWarnings("unchecked")
    public <T> T getSingleRow(String key, Object parameter) {
        if (logger.isDebugEnabled()) {
            getExecuteSql(key, parameter);
        }
        return (T) getSqlSession().selectOne(key, parameter);
    }

    /**
     * 根据Key以及传入参数，获取返回类型对应数据的List
     *
     * @param key       xml文件中sql的唯一标识，命名空间+ID
     * @param parameter 和xml的key值对应语句的参数
     */
    public <T> List<T> getList(String key, Object parameter) {
        if (logger.isDebugEnabled()) {
            getExecuteSql(key, parameter);
        }
        return getSqlSession().selectList(key, parameter);
    }

    /**
     * 根据Key以及传入参数，获取要执行的sql
     *
     * @param key       xml文件中sql的唯一标识，命名空间+ID
     * @param parameter 和xml的key值对应语句的参数
     * @return 对应的sql
     */
    public String getExecuteSql(String key, Object parameter) {
        SqlSession session = getSqlSession();
        Configuration configuration = session.getConfiguration();
        // 获取key对应的上下文句柄
        MappedStatement ms = configuration.getMappedStatement(key);
        BoundSql boundsql = ms.getBoundSql(parameter);
        String sql = boundsql.getSql();
        if (logger.isDebugEnabled()) {
            logger.debug("key:" + key + " | parameter:" + parameter + " | sql:" + sql);
        }
        return sql;
    }
}
