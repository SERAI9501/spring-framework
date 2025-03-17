package com.sist.spring1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericApplicationContext app=
				new GenericApplicationContext("app3.xml");
//		ApplicationContext app=
//				new ClassPathXmlApplicationContext("app3.xml");
		Student std=(Student)app.getBean("std");
		System.out.println("�й�:"+std.getHakbun());
		System.out.println("�̸�:"+std.getHuman().getName());
		System.out.println("����:"+std.getHuman().getSex());
		System.out.println("�ּ�:"+std.getHuman().getAddress());
		app.close();
	}

}
