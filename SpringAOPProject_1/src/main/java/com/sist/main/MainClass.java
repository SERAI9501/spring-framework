package com.sist.main;
/*
 *  Proxy => 대리자 => AOP
 *  
 *  프로그램 => 핵심 코드
 *            ------
 *            부가적인 코드 => 모아서 관리 => 공통모듈 / AOP
 *              | 데이터베이스 연결 / 데이터베이스 해제
 *              | 보안 (인가 => 인증) 이미 소스 완성되어있으니 자동호출 할 것으로 예상됨
 *              | 트랜잭션 => commit / rollback 이미 완성되어있어서 원하는 위치에서 호출
 *              | 로깅
 *              | 파일 입출력
 *              -----------------------------------------AOP 라이브러리로 되어있음
 *              | 사용자 정의 AOP (아주 가끔 등장할 예정)
 *                ------------ 인터셉트 (자동 로그인) , AOP를 이용한 자동화 둘 중 하나를 선택함
 *  
 *  중복 제거를 하기위해서 많이 쓰는게 AOP이다 => 자바에서는 메소드화 처리로 이 기능을 대체? 했었다
 *  하지만 collback이 가능하기 때문에 AOP를 더 많이 쓰일 것이다.
 *  
 *  AOP의 개념 5개
 *  1.Aspect : 공통적으로 사용되는 기능을 모아둔 장소 => 공통 모듈
 *  2.Target : 적용하는 곳 => 모아주는 역할 = 위빙
 *  3.Advice :어디에 어떤 기능을 추가할지
 *   (JoinPoint + PointCut) 아래 두가지를 합쳐서 advice라고 함 
 *  4.JoinPoion : 시점 => 어디서 호출
 *                Before
 *                After
 *                After-Returning
 *                After-Throwing
 *                Around
 *                
 *              예를들어 메소드 안에서 호출
 *                public void display() 이렇게 함수가 만들어졌을때
 *                {
 *                  =>try 진입전 => Before
 *                  try
 *                  {
 *                      ------------- Around start
 *                         => 로깅
 *                         => 어떤 메소드를 요청
 *                         => setAutoCommit(false)
 *                       핵심 코드 => 메소드 호출
 *                      ------------- Around end
 *                         => 걸린 시간 확인
 *                         => commit
 *                  }catch(Exception ex)
 *                  {
 *                    After-Throwing = > 오류발생시 처리
 *                                       에러 발생시 사용자에게 어떤 내용을 띄워줘서 알릴 것인지..
 *                  }
 *                  finally
 *                  {
 *                   => After => 무조건 수행
 *                  }
 *                   return => After-Returning 정상수행시
 *                }
 *  5.PontCut : 어떤 메소드에 적용을 할 것인지 설정하는 것. => 쓰는형식 execution("리턴형 패키지.클래스명.메소드명(..)")
 *                                                                      *                    -----
 *                                                                                        | 매개변수가 0개 이상
                =>1.메소드에 공통 적용하는 소르를 모아둔다 = Aspect
                  ---------------------------------------------- 아래 2개를 모아서 Advice라고 한다
                  2.메소드가 호출될때                 = PointCut
                  3.어떤 메소드 어떤 영역에(위치에)적용할지 설정 = JoinPoint
                                 ---------------- Weaving
                => include의 동일 : 실행시마다 자동 호출
                   ------- 공통 적용되는 소스가 있기 때문에 include시킨다.
                   
                   include 따로 빼서 처리 하는 것
                   자동화 시킨것 AOP
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		My m=new My();
		m.execute();
		
		MyTarget mt=new MyTarget(m);
		mt.execute();
	}

}
