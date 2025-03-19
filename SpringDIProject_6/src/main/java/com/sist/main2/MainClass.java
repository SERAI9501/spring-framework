package com.sist.main2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/*
 * autowired의 단점
 * 
 * POJO 방식을 주로 사용
 * ---- 일반자바 => 인터페이스/상속이 없는 독립된 클래스
 */
@Component
public class MainClass {
	 // 실무 => @Autowird+@Qualifier = @Resource
	@Autowired
	// 반드시 스프링에서 메모리가 할당이 되는 경우에만 사용기 가능하다.
	@Qualifier(value = "oracle")
	//같은 형태의 클래스가 여러개인 경우에 특정객체 지정
	private DAO dao;//DAO dao=new Oracle() ? =new MySQL
	
	
	public static void main(String[] args) {
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app2.xml");
		MainClass mc=(MainClass)app.getBean("mainClass");
		mc.dao.connection();
		
	}
}
