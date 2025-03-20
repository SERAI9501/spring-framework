package com.sist.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
 * <bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
       p:driverClassName="oracle.jdbc.driver.OracleDriver"
       p:url="jdbc:oracle:thin:@localhost:1521:XE"
       p:username="hr"
       p:password="happy"
    />
	<!-- MyBatis연동 = SqlSessionFactory 
		오라클 연결 해제 담당 갯/디스 커낵션 연결
	-->
	<bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
      p:dataSource-ref="ds"
    />
	<!-- Mapper구현 MapperFactoryBean  Spl 문장을 읽어서 전송하거나 결과값을 읽어옴 
	    아래 처럼 mapper를 저렇게 한번에 스캔하면 객체명을 모른다. 그래서 @Autowired를 요청해야 한다.
	    id가 없으니 알 수 없다.(id같은 구분자가 없다.)
	-->
	<mybatis-spring:scan base-package="com.sist.mapper" factory-ref="ssf"/>
 */
// MpperScan = <mybatis-spring:scan base-package="com.sist.mapper" factory-ref="ssf"/> 이걸로 변경되었다.
@Configuration
@MapperScan(basePackages = "com.sist.mapper")
public class DatabaseConfig {
	/*
	 * <bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
       p:driverClassName="oracle.jdbc.driver.OracleDriver"
       p:url="jdbc:oracle:thin:@localhost:1521:XE"
       p:username="hr"
       p:password="happy"
    />
	 */
	@Bean("ds")
	public DataSource dataSource() {
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setUsername("hr");
		ds.setPassword("happy");
		return ds;
	}
	/*
	 * 	<bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
      p:dataSource-ref="ds"
    />

	 */
	@Bean("ssf")
	public SqlSessionFactory sqlSessionFactory() throws Throwable
	{
		SqlSessionFactoryBean ssf=
				new SqlSessionFactoryBean();
		ssf.setDataSource(dataSource());
		
		return ssf.getObject();
		//팩토리를 넘겨주는애가 obj이다
	}
}
