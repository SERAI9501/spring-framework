package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.BoardDAO;
import com.sist.dao.*;
// AOP는 트랜잭션 / 보안 에서 자동 호출이 되고 있다.
/* 
 * insert => 에러 상관없음
 * update => 에러 
 * delete =>
 *  카드는 결제되고 포인트가 올라가지 않음 이런현상과 같음
 *  트랜젝션 프로그램은 저 셋중에 하나라도 에러가 나면 다 취소 한다. / 금융권같은곳에서 매우 중요함
 * public void insert()
 * {
 *   try
 *   {
 *  	getConnection()
 *  	conn,setAtutoCommit(false)
 *   }
 * }
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		//BoardDAO dao=new BoardDAO();
		BoardDAO dao=(BoardDAO)app.getBean("dao");
		dao.boardListData(1);
		dao.boardDetatilData("홍길동");
		dao.boardInsert();
		dao.boardUpdate();
		dao.boardDelete();
	}

}
