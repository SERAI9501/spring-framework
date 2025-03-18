package com.sist.main;
/*
 *  ������
 *    => Ŭ���� ���� ����
 *       -------- �����̳� Ŭ����
 *         BeanFactory
 *              |
 *        ApplicationContext => XML Ŭ���� ���
 *              |- AnnotationConfigApplicationContext
 *                 => �ڹٷ� ��� => 5�����̻󿡼� ���� (����)
 *      WebApplicationContext
 *      
 *      ** Component : Ŭ���� �Ѱ� (����� ������ �ִ� Ŭ����) 
 *                     �� JBoutton / Java TextField
 *                       ~Model   / ~Manager        / ~DAO => ��ǰ
 *                     => CUP / �޸� / �ϵ��ũ
 *      ** Container : ������ => Ŭ���������ϴ� ����
 *                     => ���κ���
 *             | Ŭ���� ����
 *               --------
 *               1) ��ü ����
 *                 <bean id="a" class="com.sist.main.A"> => ���Ⱑ ��ü�� �����Ǵ� �κ�
 *                   => Class clsName=Class.forName("com.sist.main.A")
 *                      object obj=clsName.newInstance() => ��ü ��������
 *                      => map.put("a",obj) => ������
 *               2) �����ÿ� ��������� ���� �ʱ�ȭ
 *                  ----------------------- DI
 *                    | setXxx() => setter DI ���Ϳ� ���� ä����
 *                    | ������ �Ű����� => constructor DI
 *                    | ������ / �Ҹ�ÿ� �޼ҵ� ȣ�� => method DI(�ѹ��� ȣ�� �� �� �ִ�)
 *               3) ��ü�� ã�� => DL => getBean()
 *               4) ��ü �Ҹ�
 *             | ��� 3��
 *               Ŭ���� ��� / DI
 *               1) XML : ����
 *               2) Annotation : ����
 *               3) XML+Annotation => ��/ �ǹ����� �ַ� ���
 *                 ---- ----------
 *                         | ����� ���� Ŭ���� ���� ������̼� ���
 *                 |������Ʈ���� ���� ���Ǵ� �κ� / ���̺귯�� Ŭ����
 *                                            ------------
 *                                            MyBatis / Transaction
 *             => �������� ���Ǵ� Ŭ������ �޼ҵ带 ��Ƽ� ���� �ϴ°� = ������
 *                => com.sist.commons
 *                => �ڵ� ȣ���� ���� (AOP)
 *             => �� => MVC
 *                => �߰������� ���� ���� (Task , Security / Batch / SI / Spring-Data)
 *             => �����ӿ�ũ VS ���̺귯��   
 *                -------    -------
 *                 ����         ����ǰ
 *               => �⺻ ������ ���� Ʋ�� ��������ִ�
 *               
 *                 ���Ŀ� �°� ������ ���
 *                 --- XML / Annotation
 *                              |�̹� ������� �ִ� = @Controller / @RequestMapping
 *                      | �̹� �±װ� ������� �ִ� (�Ӽ�) => DTD/��Ű��
 *                 --- ���̺귯�� �߰� : pom.xml / gradle(Spring-Boot)
 *               
 *     ���������� �����ϴ� ���̺귯��
 *       = spring-core : Container/DI
 *       = spring-aop  : AOP = �������̶� ��
 *       = spring=orm  : orm Mabatis / JPA
 *       = spring=dao  : JDBC
 *       = spring=web / spring-webmvc
 *       
 *     ������ ��� ����
 *       = ���꼺�� ���� => ���̺귯���� �پ�� / �ŷڼ��� ���� / ���� ����
 *       = ���� ������ ���ϴ� / Ȯ�强�� ���� = �ٸ� ���� ������ ����
 *       = ���� �����̴�. �츮���� ��ȣ�ϴ� ���� / ������� �������� �����ؼ� ����� �����ϴ�.
 *       = *** ���� ����ϴ� ����� �°� ���̺귯���� ���۵ǰ� �ִ�
 *             ------------- AI / MSA
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
