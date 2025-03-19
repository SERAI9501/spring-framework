package com.sist.main;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/*
 *  XML / Annotation => 클래스를 모아서 관리
 *  => 클래스 등록시
 *     --------- 1)기능을 가지고 있는 클래스 = 컴포넌트
 *                                         | 컨테이너 (스프링)
 *                 DAO / Manager / Service / Model
 *                 VO,DTO,Bean => 사용자 데이터형 (클래스등록X)
 *     클래스 등록
 *      <bean id="" class=""> : 메모리 할당후에 저장
 *       => singleton : 한개의 메모리로 재사용
 *       => 여러개 생성 : prototype => 복제해서 새로운 메모리 생성
 *          <bean id="" class="" scope="prototype">
 *                      => Object clone()
 *       => <bean id="" class=""> => 기본 디폴트 생성자 호출
 *       => id는 클래스를 찾기 위한 구분자 => 반드시 중복없이 설정
 *       => 컨테이너안에 저장
 *          ====== 스프링에서 지원
 *                 BeanFactory : core(DI, 객체 생성/ 객체 소멸)
 *                     |
 *               ApplicationContext : + AOP , 국제화
 *               ------------------ XML로 등록된 경우
 *               AnootaionConfigApplicationContext
 *               --------------------------------- 자바로 설정 (보안)
 *                | 5버전 이상에서 많이 권장
 *                   |
 *         WebApplicationContext : +MVC (WEB) => Controller
 *                                               ----------
 *                                               DispatcherServlet
 *                                               | 처리 메소드 찾기
 *                                                -------------
 *                                                @RequestMapping
 *                                                 => GET/POST 동시
 *                                                @GetMapping
 *                                                @PostMapping
 *       Spring에서 지원 5가지 (입사시 => 공통기반) Spring Basic : 여러명이 동시에 개발할때 쓴다.
 *        유지보수에 기반을 두기 때문이다.
 *        = DI => 70% 꼭 이해할것 (핵심)
 *        = AOP => 반복 제거 (공통기반의 클래스 제작)
 *        = ORM => 데이터베이스 연결 (MyBatis,JPA,Hibernate)
 *        = MVC
 *        = Security
 *        
 *        1) DI => 주입
 *           -- IoC => DI 
 *              --- 제어의 역전 (마틴파울러)
 *              범위 => 클래스와 클래스의 연관 관계를 설정 (예전에는 클래스 다이어그램 만듬)
 *              	   => p:객체명-ref="id명"
 *                     클래스에 필요한 데이터 주입
 *                     --------------------
 *                     => p:변수명="값"
 *                        -----------
 *                        setter / constructor
 *                        --------------------- XML에서만 가능
 *                        어노테이션에서는 사용이 불가능
 *          클래스 한개 메모리 할당 
 *            <bean>
 *          클래스 여러개 메모리 할당
 *            <context:component-scan basepackage="">
 *            =>선별해서 메모리 할당 요청
 *               -------------- 메모리에 할당된 객체만 스프링이 관리한다.
 *               @Controller : Model 클래스 = 요청처리 => Web
 *               @Component : 일반클래스를 지정할때 => MainClass..
 *               @Repository : 저장소 => DAO
 *               @Service : BI => 통합 (DAO 여러개를 한번에 통합시에 주로 사용)
 *                          예) EmpDAO / DeptDAO
 *                             -----------------조인이나 서브쿼리가 걸려있을때
 *               @RestController : 다른 프로그램이랑 연결할때
 *                                 ---------- 웹에서 보통적으로는 자바스크립트 (JSON 보낼 때)
 *                                                           ----------------------
 *                                                           | VueJS
 *               @ControllerAdvice : 공통 예외처리 (이걸 걸어두면 메소드 마다 둘 필요 없이 에러를 다 잡아준다)
 *               @RestControllerAdvice : 공통 예외처리
 *               @Bean : 자바로 클래스 설정 했을때 사용
 *                 <bean> 을대신해서 나옴
 *               ---------------------
 *               클래스 위에 이중에 하나가있어야만 메모리 할당을 한다.
 *               
 *               3가지 방식
 *               1. 클래스를 한개씩 등록하는 방식 <bean>으로 등록 / 한파일을 가지고 100명이 동시에 쓴다고 상상해보자 
 *                    | XML코드
 *    오늘배울내용- 2. 모든 클래스를 한번에 등록하는 방식 : 패키지 단위 등록
 *                    | 어노테이션 코드
 *               3. XML + Annotation 방식
 *                   |      | 개별 클래스 (=사용자 정의 클래스)
 *                  XML을 사용할때는 공통으로 적용해야하는 부분들을 짤때 쓴다 (=라이브러리 클래스) => DAO / 보안 등 적용
 *                  
 *              모든 라이브러리를 상속 받아서 처리해야한다?
 *              
 *              빈과 XML 어노테이션 이중 어느게 편한지.. => com.sist.goods~sawon
 *              
 *              어노테이션은 세터가 안된다. 초기값을 넣어줘야한다.
 *              
 *             
 *             메모리 할당을 지정해야 한다.  <context:component-scan base-package="com.sist.*"/> 이것만으로는 아무것도 불러 올 수 없다
 *             아래 처럼 어노테이션을 올리면 메모리 할당이 된다.
 *             // <bean id="sa" class="com.sist.sawon.SawonManager"/> = @Component("sa") 동일한 코딩
 *             @Conponent("") 아이디를 지정할 수 있고 @Conponent 이렇게 아이디를 지정하지 않는 경우가 있음
 *             아이디를 지정하지 않으면 맨 첫글자만 소문자로 나머지는 그대로 쓰면 불러 올 수 있다.
 *             
 *             public void setSawon(Sawon sawon) {
				this.sawon = sawon;
				}
				위 클래스가 이해가 안감
				
				p = property
 */
import com.sist.goods.*;
import com.sist.member.*;
import com.sist.sawon.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 등록한 XML을 컨테이너로 전송
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		//클래스 찾기 -> 활용
		SawonManager sa=(SawonManager)app.getBean("sa");
		sa.display();
		MemberManager mem=(MemberManager)app.getBean("mem");
		mem.display();
		GoodsManager goods=(GoodsManager)app.getBean("goods");
		goods.display();
		// 갯 빈을 이용해야 찾아 올 수 있다. 
	}

}
