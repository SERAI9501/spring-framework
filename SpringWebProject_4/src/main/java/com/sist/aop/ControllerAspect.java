package com.sist.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
/*
 * 	기능이 있는 클래스 => 관리 스프링에게 맡긴다
 *                    객체 생성 ~ 소멸
 *                    -------
 *                    1.메모리 할당
 *                    2.멤버변수의 초기화
 *                      DI => setXxx() , 생성자
 *                      --
 *                    3. 필요시마다 객체를 찾아서 사용이 가능
 *                    	 DL => @Autowired
 *                    ------------------------------
 *                     => 클래스 관리자 (Container) = 스프링 해주는 역할의 기본
 *                        복잡한 클래스가 많은 경우에 사용 = 관계도가 많은 경우
 *                        ----------
 *                        => 연관관계가 없는 독립적인 클래스 제작
 *                     => MVC는 스프링의 라이브러리에 불과하다. 목적은 관리를 해주는게 목적 
 *          객체 생성 요청
 *          -----------
 *          각 클래스마다 메모리 할당
 *          <bean id="" class="">
 *          => 모든 클래스를 관리하는건 아니다.
 *            ex)인터페이스 , 사용자 정의 데이터형 , 임시 클래스 등..
 *            WEB 일 때 관리대상은? => 선택적 메모리 할당 이라고 표현함
 *                @Repository
 *              1.DAO
 *                @Service
 *              2.Service
 *                @Controller
 *              3.Model
 *                @Component
 *              4.Manager
 *                @Component
 *              5.AOP
 *              
 *          기타적으로 @RestController / @ControllerAdvice 가 있다
 *          위 어노테이션이 올라간 클래스만 관리해준다.
 *          => 나머지는 개발자 관리
 *          => DI 의 본 목적 = 메모리 할당 그리고 관리
 *              = 객체의 생명주기
 *              = 클래스와 클래스의 연관 관계 설정
 *              ---------------------------
 *              오버로딩 / 오버라이딩
 *                |        |
 *               new     modify기존 기능을 바꿈
 *           새로운기능 추가
 *        AOP : 공통 모듈 (여러 위치에 호출)
 *             => 보안 / 로깅 / 트랜잭션 에서 많이 등장
 *                --          -----
 *                 |            |
 *                 --------------
 *                       |AOP로 이미 만들어져있다 = 어노테이션으로 되어있단 의미 / XML로 따지지 않는다.
 *                    로깅은 안만들어져있어서 우리가 만들어야한다.
 *      
 *      중복 제거
 *      -------
 *        OOP => 메소드 , 메소드 많은 경우 클래스
 *        AOP => ------------------------- 자동 호출이 가능
 *        --- OOP를 보완한 프로그램이다.
 *        
 *        OOP와 AOP에 대해서 설명하시오.
 *        
 *      자동 호출
 *      -------
 *      어떤 메소드에서 호출 : PointCut
 *      메소드 영역안에 어떤 위치에서 호출 : JoinPoint
 *      -------------------------------------- Advice
 *       public String display()
 *       {
 *       	=>Before
 *          try
 *          {
 *             ============ 시작점 Around
 *             소스
 *             ============ 끝 Around 이렇게 2곳에 줄 수 있다 트랜잭션,로그 = (시간을 잴 때,오토커밋 등)
 *          }catch(Exception e)
 *          {
 *          	=> After-Throwing 오류 잡아라
 *          }
 *          finally
 *          {
 *          	=> After
 *          }
 *          return "" => After-Returning
 *       }
 *        
 *        PointCut사용시
 *        PointCut
 *        execution("* 패키지명.클래스.메소드(..)") => 현재상태는 모든 리턴형+모든매개변수를 선택했다
 *                   |                   |
 *                   리턴형              매개변수 (0개이상)
 *        within("패키지") => 지정된 패키지에 있는 모든 클래스에 적용
 *        
 *        => Advice(JoinPoint+PointCut)
 *          ----------------------------Advice가 여러개 일때 Aspect
 *           
 */
@Aspect
@Component
public class ControllerAspect {
   @Around("execution(* com.sist.web.*Controller.*(..))")
   public Object around(ProceedingJoinPoint jp)
   throws Throwable
   {
	  Object obj=null;
	  long start=System.currentTimeMillis();
	  System.out.println("호출 메소드:"+jp.getSignature().getName());
	  obj=jp.proceed(); 
	  long end=System.currentTimeMillis();
	  System.out.println("수행시간:"+(end-start));
	  return obj;
   }
   @AfterReturning(value = "execution(* com.sist.web.*Controller.*(..))",returning = "obj")
   public void afterReturning(Object obj)
   {
	   if(obj!=null)
	   {
		   String path=(String)obj;
		   System.out.println("호출된 JSP:"+path);
		   
	   }
   }
   // => ControllerAdvice: Controller예외처리를 공통으로 처리
   
}