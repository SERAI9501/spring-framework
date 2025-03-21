package com.sist.dao;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/*
 * 	���ռ��� ���� ���α׷� => �������� �����ڰ� ���� ����
 *  ---------------- Container / POJO / DI
 *                                       |�ʿ�ÿ� Ŭ���� �޸� �Ҵ��� �� �� ��������� �ʱ�ȭ �ϴ� �� = DI
 *                                | �ٸ� Ŭ������ ������ ���� �������� Ŭ������ ����
 *                                  => �������̽��� ����� ������� �ʰ� �Ϲ� �ڹ� Ŭ������ ����Ѵ�.
 *                   | Ŭ������ ������ ��Ƽ� ����
 *  
 *  ���� �ҽ��� ���� �߻� => �������� ���Ǵ� �ҽ��� ��Ƽ� ����
 *                      ===========================
 *                      | ������ => AOP (Ⱦ������ ���α׷�)
 *                    	  =>�ݺ� �ڵ��� ���� �ʴ´�
 *                      | OOP VS AOP
 *                        => AOP  OOP�� ������ ����
 *                        => CallBack => �ڵ� ȣ��
 *                        => � �޼ҵ�����
 *                        => ��� ����
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
 *  @ ���۽� ȣ�� = Before��� �Ѵ�
 *  try
 *  {
 *   ----------------- Around setAutoCommit(false)
 *   �ҽ��ڵ�
 *   �ҽ��ڵ�
 *   ----------------- commit () => Ʈ����� / �α������� © �� ���� �����ϴ°� Around...
 *  								--------------- ���������� ���̺귯�� ó��	
 *  }
 *  catch(Exception ex)
 *  {
 *  	@���� ���ǽ� ȣ�� =After-Throwing �����
 *  }
 *  finally
 *  {
 *  	@After
 *  }
 *  return @== After-Returning
 *  
 *  �⺻
 *   => �ڵ� �ҽ� �Ʒ� 2���� �ִ�
 *      -------
 *      ���� ���Ǵ� �ҽ�
 *      �ٽ� ���Ǵ� �ҽ�
 */
public class BoardDAO {
  public void getConnection()
  {
	  System.out.println("����Ŭ ����!!");
  }
  public void disConnection()
  {
	  System.out.println("����Ŭ �ݱ�!!");
  }
  public void boardListData(int page)
  {
//	  getConnection();
	  System.out.println(page+"������ ��� ���");
//	  disConnection();
  }
  public String boardDetatilData(String name)
  {
//	  getConnection();
	  System.out.println(name+"�� ���� �󼼺���");
//	  disConnection();
	  return name;
  }
  public void boardInsert()
  {
//	  getConnection();
	  System.out.println("�Խù� �߰� �Ϸ�");
//	  disConnection();
  }
  public void boardUpdate()
  {
//	  getConnection();
	  System.out.println("�Խù� ���� �Ϸ�");
//	  disConnection();
  }
  public void boardDelete()
  {
//	  getConnection();
	  System.out.println("�Խù� ���� �Ϸ�");
//	  disConnection();
  }
  public void print()
  {
	  System.out.println("���α׷� ����");
  }
}