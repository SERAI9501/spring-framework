package com.sist.main2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/*
 * autowired�� ����
 * 
 * POJO ����� �ַ� ���
 * ---- �Ϲ��ڹ� => �������̽�/����� ���� ������ Ŭ����
 */
@Component
public class MainClass {
	 // �ǹ� => @Autowird+@Qualifier = @Resource
	@Autowired
	// �ݵ�� ���������� �޸𸮰� �Ҵ��� �Ǵ� ��쿡�� ���� �����ϴ�.
	@Qualifier(value = "oracle")
	//���� ������ Ŭ������ �������� ��쿡 Ư����ü ����
	private DAO dao;//DAO dao=new Oracle() ? =new MySQL
	
	
	public static void main(String[] args) {
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app2.xml");
		MainClass mc=(MainClass)app.getBean("mainClass");
		mc.dao.connection();
		
	}
}
