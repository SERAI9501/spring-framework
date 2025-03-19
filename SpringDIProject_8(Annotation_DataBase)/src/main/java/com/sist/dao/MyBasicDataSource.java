package com.sist.dao;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.stereotype.Component;
/*
 * <bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
		p:driverClassName="oracle.jdbc.drivaer.OracleDriver"
		p:url="jdbc:oracle:thin:@localhost:1521:XE"
		p:username="hr"
		p:password="happy"
	/>
	 * 위 bean 부분을 자바로 구현하는것
 */
@Component("ds")
public class MyBasicDataSource extends BasicDataSource{
	public MyBasicDataSource()
	{
		setDriverClassName("oracle.jdbc.drivaer.OracleDriver");
		setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		setUsername("hr");
		setPassword("happy");
	}
}
