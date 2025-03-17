package com.sist.spring1;
/*
 *  HelloMain는 Hello에 의존한다 => 결합성이 강한 프로그램 = 에러시에 다른 클래스가 에러가 나는 경우
 *                               ----------------
 *                               =유지보수가 어렵다
 *  가급적이면  => new를 사용하지 않아야 한다.
 *              ---- 사용한다면? 결합성이 높아진다.                             
 *  
 *  => 결합성이 낮은 프로그램 구현
 *  => ---------------- 세미나 => 발표자 (로드존슨)
 *                                    ------- Open Source 의 등장
 *                                            -----------
 *                                            spring.io 에서 받아준다
 *                                            ---------
 *                                             2.5버전까지 발전했다
 *   웹로직 / 웹스페어 => 툴사용 <= 하지만 비용이 바싸다.
 *                                  ---------- 스프링 등장 (무료)
 *  
 */
public class HelloMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hello hello=new Hello();
		String msg=hello.seyHello("홍길동");
		System.out.println(msg);
	}

}
