package com.sist.dao;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/*
 * <bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
		p:dataSource-ref="ds"
	/>
	위 부분을 자바로 구현하는것
 */
@Component("ssf")
public class MySqlSessionFactoryBean extends SqlSessionFactoryBean{
	@Autowired  //  |p:dataSource          
	public void setDataSource(DataSource dataSource)//p:dataSource-ref 메소드명:dataSource 
	{
		super.setDataSource(dataSource);
	}
}
