package com.sist.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/*
 * <bean id="mapper" class="org.mybatis.spring.mapper.MapperFactoryBean"
		p:sqlSessionFactory-ref="ssf" 스프링에서 넣어주는 곳 / 오토와이어드
		p:mapperInterface="com.sist.mapper.EmpMapper" 사용자설정값 / 오토와이어드(x)
	/>
	 p:name = setName
	 p:sqlSessionFactory = setSqlSessionFactory(ssf)
 */
@Component("mapper")
public class MyMapperFactoryBean extends MapperFactoryBean{

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	public MyMapperFactoryBean()
	{
		setMapperInterface(com.sist.mapper.EmpMapper.class);
	}
}
