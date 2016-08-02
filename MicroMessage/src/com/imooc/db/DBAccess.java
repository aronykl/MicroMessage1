package com.imooc.db;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 数据库访问代码
 * @author Administrator
 *
 */
public class DBAccess {
	
	public SqlSession getSqlSession() throws IOException {
		//通过配置文件获取数据库连接信息
		Reader reader = Resources.getResourceAsReader("com/imooc/config/Configuration.xml");
		//通过配置信息构建一个SQLSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		//通过SQLSessionFactory打开一个数据库会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession;
	}

}
