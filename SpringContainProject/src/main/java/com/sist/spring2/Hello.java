package com.sist.spring2;
/*
 *   A <===> B
 *   
 *   A <==> I <==> B
 *         ---
 *         에러 막아주는 역할
 *         | 인터페이스가 오류가 나면
 *           인터페이스와 관련된 모든 클래스가 오류가 난다
 *           ------- 고정해서 사용한다.
 */
public interface Hello {
	public String sayHello(String name);
}
