package com.example.springboot.mapper;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import javax.annotation.Resource;

/**
 *  sqlSessionFactory无法注入，报Property 'sqlSessionFactory' or 'sqlSessionTemplate' are required
 *  mybatis-spring-1.2.0 -- mybatis 升级到高版本，取消了自动注入
 */
public abstract class BaseMapper extends SqlSessionDaoSupport {

    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    protected <S> S getMapper(Class<S> clazz) {
        return getSqlSession().getMapper(clazz);
    }

}
