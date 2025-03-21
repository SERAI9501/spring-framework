package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.BoardDAO;
import com.sist.dao.*;
// AOP�� Ʈ����� / ���� ���� �ڵ� ȣ���� �ǰ� �ִ�.
/* 
 * insert => ���� �������
 * update => ���� 
 * delete =>
 *  ī��� �����ǰ� ����Ʈ�� �ö��� ���� �̷������ ����
 *  Ʈ������ ���α׷��� �� ���߿� �ϳ��� ������ ���� �� ��� �Ѵ�. / �����ǰ��������� �ſ� �߿���
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
		dao.boardDetatilData("ȫ�浿");
		dao.boardInsert();
		dao.boardUpdate();
		dao.boardDelete();
	}

}
