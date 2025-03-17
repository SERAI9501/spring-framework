package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 *  ������ �����ӿ�ũ
 *  ------------
 *  1.Container : Ŭ������ ��Ƽ� ����
 *    BeanFactory
 *      |
 *    ApplicationContext : default
 *     |
 *     WebApplicataionContext : core (��ü ���� / DI / AOP / MVC) 
 *     
 *     => GenericApplicationtim
 *     => AnnotationConfigApplicationContext
 *      => 5���� �ַ� ���
 *         ---- ���ȿ� �ַ�
 *         ��� : Ʒ =>�����ڹ� ������ ����
 *         
 *       ���
 *        = ��ü �����ֱ� ���� (���� ~ �Ҹ�) => ��� Ŭ���� (VO=��=:��������)
 *        = ��ü ã��
 *        = DI(��ü ã��) / DI (������ �ʱ�ȭ)
 *        
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        	 new ClassPathXmlApplicationContext("app1.xml");
        Sawon sa=(Sawon)app.getBean("sa1");
        sa.print();
        
        Sawon sa1=(Sawon)app.getBean("sa2");
        sa1.print();
        
        Sawon sa2=(Sawon)app.getBean("sa3");
        sa2.print();
        
        Sawon sa3=(Sawon)app.getBean("sa4");
        sa3.print();
        
        Sawon sa4=(Sawon)app.getBean("sa5");
        sa4.print();
        
	}

}