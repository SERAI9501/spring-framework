package com.sist.member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.sist.sawon.*;
@Component("mem")
// Target (value=(TYPE))
/*
 *  어노테이션 => 구분자
 *  TYPE => 클래스 구분
 * 	
 *  class A
 *  (
 *  	// 멤버변수를 구분할 때 FIELD
 *  	B b
 *  	public A() {} => CONSTRUCTOR
 *  	public void setB(B b){} => METHOD
 *                      ----- PRAMETER 매개변수도 올라가는데 이름이 파라미터이다
 *  )
 */
public class Member {
	@Autowired
	/* 오토 와이어드가 들어갈 수 있는 자리
	 * 스프링에서 같은 객체를 찾아서 값을 넣어주는 역할을 함
	 * CONSTRUCTOR
	 * METHOD
	 * PARAMETER
	 * FIELD
	 * ANNOTATION_TYPE = 2개의 어노테이션을 쓴다는 의미
	 */
//	@Qualifier
	private Sawon sawon;// sawon의 객체를 찾아서 주소를 대입
//	@Autowired
//	public Member(@Autowired Sawon sawon) {}
//	@Autowired
//	public void setSawon(Sawon sawon) {
//		this.sawon = sawon;
//	}
	public void display() {
		System.out.println("sawon:sawon");
		System.out.println("사번:"+sawon.getSabun());
		System.out.println("이름:"+sawon.getName());
	}
	public void setSawon(Sawon sawon) {
		this.sawon = sawon;
	}
}
