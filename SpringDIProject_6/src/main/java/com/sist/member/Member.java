package com.sist.member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.sist.sawon.*;
@Component("mem")
// Target (value=(TYPE))
/*
 *  ������̼� => ������
 *  TYPE => Ŭ���� ����
 * 	
 *  class A
 *  (
 *  	// ��������� ������ �� FIELD
 *  	B b
 *  	public A() {} => CONSTRUCTOR
 *  	public void setB(B b){} => METHOD
 *                      ----- PRAMETER �Ű������� �ö󰡴µ� �̸��� �Ķ�����̴�
 *  )
 */
public class Member {
	@Autowired
	/* ���� ���̾�尡 �� �� �ִ� �ڸ�
	 * ���������� ���� ��ü�� ã�Ƽ� ���� �־��ִ� ������ ��
	 * CONSTRUCTOR
	 * METHOD
	 * PARAMETER
	 * FIELD
	 * ANNOTATION_TYPE = 2���� ������̼��� ���ٴ� �ǹ�
	 */
//	@Qualifier
	private Sawon sawon;// sawon�� ��ü�� ã�Ƽ� �ּҸ� ����
//	@Autowired
//	public Member(@Autowired Sawon sawon) {}
//	@Autowired
//	public void setSawon(Sawon sawon) {
//		this.sawon = sawon;
//	}
	public void display() {
		System.out.println("sawon:sawon");
		System.out.println("���:"+sawon.getSabun());
		System.out.println("�̸�:"+sawon.getName());
	}
	public void setSawon(Sawon sawon) {
		this.sawon = sawon;
	}
}
