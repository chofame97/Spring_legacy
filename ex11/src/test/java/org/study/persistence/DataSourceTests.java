package org.study.persistence;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DataSourceTests {
	
	@Autowired
	private DataSource ds;
	
	@Autowired
	private SqlSessionFactory sessionFactory;
	
	@Test
	public void testConnection(){
	
		try(Connection con = ds.getConnection()) {
			log.info(con);
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			
		}
	}
	
	@Test
	public void testConnection2() {
		try(SqlSession session = sessionFactory.openSession();
				Connection con = session.getConnection()){
			log.info(session);
			log.info(con);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
