package com.sist.dao;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/*
 * 	결합성이 낮은 프로그램 => 여러명의 개발자가 동시 개발
 *  ---------------- Container / POJO / DI
 *                                       |필요시에 클래스 메모리 할당을 할 때 멤버변수를 초기화 하는 것 = DI
 *                                | 다른 클래스에 영향이 없게 독립적인 클래스를 만듦
 *                                  => 인터페이스나 상속을 사용하지 않고 일반 자바 클래스를 사용한다.
 *                   | 클래스를 여러개 모아서 관리
 *  
 *  동일 소스가 많이 발생 => 공통으로 사용되는 소스를 모아서 관리
 *                      ===========================
 *                      | 공통모듈 => AOP (횡단지향 프로그램)
 *                    	  =>반복 코딩을 하지 않는다
 *                      | OOP VS AOP
 *                        => AOP  OOP의 단점을 보완
 *                        => CallBack => 자동 호출
 *                        => 어떤 메소드인지
 *                        => 어느 시점
 *  try
 *  {
 *  	getConnection() ==> BEFORE
 *  }
 *  catch(Exception ex)
 *  {
 *  	ex.printStackTrace()
 *  }
 *  finally
 *  {
 *  	disConnection() ==> AFTER
 *  }
 *  @ 시작시 호출 = Before라고 한다
 *  try
 *  {
 *   ----------------- Around setAutoCommit(false)
 *   소스코딩
 *   소스코딩
 *   ----------------- commit () => 트랜잭션 / 로그파일을 짤 때 많이 등장하는게 Around...
 *  								--------------- 스프링에서 라이브러리 처리	
 *  }
 *  catch(Exception ex)
 *  {
 *  	@오류 생실시 호출 =After-Throwing 라고함
 *  }
 *  finally
 *  {
 *  	@After
 *  }
 *  return @== After-Returning
 *  
 *  기본
 *   => 코딩 소스 아래 2개가 있다
 *      -------
 *      공통 사용되는 소스
 *      핵심 사용되는 소스
 */
public class BoardDAO {
  public void getConnection()
  {
	  System.out.println("오라클 연결!!");
  }
  public void disConnection()
  {
	  System.out.println("오라클 닫기!!");
  }
  public void boardListData(int page)
  {
//	  getConnection();
	  System.out.println(page+"페이지 목록 출력");
//	  disConnection();
  }
  public String boardDetatilData(String name)
  {
//	  getConnection();
	  System.out.println(name+"에 대한 상세보기");
//	  disConnection();
	  return name;
  }
  public void boardInsert()
  {
//	  getConnection();
	  System.out.println("게시물 추가 완료");
//	  disConnection();
  }
  public void boardUpdate()
  {
//	  getConnection();
	  System.out.println("게시물 수정 완료");
//	  disConnection();
  }
  public void boardDelete()
  {
//	  getConnection();
	  System.out.println("게시물 삭제 완료");
//	  disConnection();
  }
  public void print()
  {
	  System.out.println("프로그램 종료");
  }
}