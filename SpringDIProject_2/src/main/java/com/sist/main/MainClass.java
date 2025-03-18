package com.sist.main;
/*
 *  스프링
 *    => 클래스 관리 영역
 *       -------- 컨테이너 클래스
 *         BeanFactory
 *              |
 *        ApplicationContext => XML 클래스 등록
 *              |- AnnotationConfigApplicationContext
 *                 => 자바로 등록 => 5버전이상에서 권장 (보장)
 *      WebApplicationContext
 *      
 *      ** Component : 클래스 한개 (기능을 가지고 있는 클래스) 
 *                     예 JBoutton / Java TextField
 *                       ~Model   / ~Manager        / ~DAO => 부품
 *                     => CUP / 메모리 / 하드디스크
 *      ** Container : 조립자 => 클래스관리하는 영역
 *                     => 메인보드
 *             | 클래스 관리
 *               --------
 *               1) 객체 생성
 *                 <bean id="a" class="com.sist.main.A"> => 여기가 객체가 생성되는 부분
 *                   => Class clsName=Class.forName("com.sist.main.A")
 *                      object obj=clsName.newInstance() => 객체 생성상태
 *                      => map.put("a",obj) => 대기상태
 *               2) 생성시에 멤버변수에 대한 초기화
 *                  ----------------------- DI
 *                    | setXxx() => setter DI 세터에 값을 채워줌
 *                    | 생성자 매개변수 => constructor DI
 *                    | 생성시 / 소멸시에 메소드 호출 => method DI(한번만 호출 할 수 있다)
 *               3) 객체를 찾기 => DL => getBean()
 *               4) 객체 소멸
 *             | 방법 3개
 *               클래스 등록 / DI
 *               1) XML : 공통
 *               2) Annotation : 개별
 *               3) XML+Annotation => 웹/ 실무에서 주로 사용
 *                 ---- ----------
 *                         | 사용자 정의 클래스 들은 어노테이션 사용
 *                 |프로젝트에서 공통 사용되는 부분 / 라이브러리 클래스
 *                                            ------------
 *                                            MyBatis / Transaction
 *             => 공통으로 사용되는 클래스나 메소드를 모아서 관리 하는것 = 공통모듈
 *                => com.sist.commons
 *                => 자동 호출이 가능 (AOP)
 *             => 웹 => MVC
 *                => 추가적으로 배우는 내용 (Task , Security / Batch / SI / Spring-Data)
 *             => 프레임워크 VS 라이브러리   
 *                -------    -------
 *                 레고         완제품
 *               => 기본 동작을 위한 틀이 만들어져있다
 *               
 *                 형식에 맞게 셋팅후 사용
 *                 --- XML / Annotation
 *                              |이미 만들어져 있다 = @Controller / @RequestMapping
 *                      | 이미 태그가 만들어져 있다 (속성) => DTD/스키마
 *                 --- 라이브러리 추가 : pom.xml / gradle(Spring-Boot)
 *               
 *     스프링에서 제공하는 라이브러리
 *       = spring-core : Container/DI
 *       = spring-aop  : AOP = 공통모듈이란 뜻
 *       = spring=orm  : orm Mabatis / JPA
 *       = spring=dao  : JDBC
 *       = spring=web / spring-webmvc
 *       
 *     스프링 사용 목적
 *       = 생산성이 좋다 => 라이브러리가 뛰어나다 / 신뢰성이 좋다 / 빠른 개발
 *       = 유지 보수가 편하다 / 확장성이 좋다 = 다른 언어랑 연동이 좋다
 *       = 무료 버전이다. 우리나라가 선호하는 이유 / 마음대로 스프링을 변경해서 사용이 가능하다.
 *       = *** 현재 사용하는 기술에 맞게 라이브러리가 제작되고 있다
 *             ------------- AI / MSA
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
