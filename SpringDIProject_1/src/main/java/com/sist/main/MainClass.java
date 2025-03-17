package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 *  스프링 프레임워크
 *  ------------
 *  1.Container : 클래스를 모아서 관ㄹ
 *    BeanFactory
 *      |
 *    ApplicationContext : default
 *     |
 *     WebApplicataionContext : core (객체 생성 / DI / AOP / MVC) 
 *     
 *     => GenericApplicationtim
 *     => AnnotationConfigApplicationContext
 *      => 5버전 주로 사용
 *         ---- 보안에 주력
 *         등록 : 틔 =>순수자바 설정이 가능
 *         
 *       기능
 *        = 객체 생명주기 관리 (생성 ~ 소멸) => 모든 클레스 (VO=ㄷ=:데이터형)
 *        = 객체 찾기
 *        = DI(객체 찾기) / DI (변수의 초기화)
 *        
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app1.xml");
		//Sawon sa=(Sawon)app.getBean("sa1");
		//sa.print();
		
		Sawon sa2=(Sawon)app.getBean("sa3");
		sa2.print();
	}

}
