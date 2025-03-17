package com.sist.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app2.xml");
		Member m1=app.getBean("mem",Member.class);
		System.out.println("��ȣ:"+m1.getMno());
		System.out.println("�̸�:"+m1.getName());
		System.out.println("�ּ�:"+m1.getAddress());
		
		Member m2=app.getBean("mem",Member.class);
		m2.setMno(1);
	}

}
