package com.sist.main;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/*
 *  XML / Annotation => Ŭ������ ��Ƽ� ����
 *  => Ŭ���� ��Ͻ�
 *     --------- 1)����� ������ �ִ� Ŭ���� = ������Ʈ
 *                                         | �����̳� (������)
 *                 DAO / Manager / Service / Model
 *                 VO,DTO,Bean => ����� �������� (Ŭ�������X)
 *     Ŭ���� ���
 *      <bean id="" class=""> : �޸� �Ҵ��Ŀ� ����
 *       => singleton : �Ѱ��� �޸𸮷� ����
 *       => ������ ���� : prototype => �����ؼ� ���ο� �޸� ����
 *          <bean id="" class="" scope="prototype">
 *                      => Object clone()
 *       => <bean id="" class=""> => �⺻ ����Ʈ ������ ȣ��
 *       => id�� Ŭ������ ã�� ���� ������ => �ݵ�� �ߺ����� ����
 *       => �����̳ʾȿ� ����
 *          ====== ���������� ����
 *                 BeanFactory : core(DI, ��ü ����/ ��ü �Ҹ�)
 *                     |
 *               ApplicationContext : + AOP , ����ȭ
 *               ------------------ XML�� ��ϵ� ���
 *               AnootaionConfigApplicationContext
 *               --------------------------------- �ڹٷ� ���� (����)
 *                | 5���� �̻󿡼� ���� ����
 *                   |
 *         WebApplicationContext : +MVC (WEB) => Controller
 *                                               ----------
 *                                               DispatcherServlet
 *                                               | ó�� �޼ҵ� ã��
 *                                                -------------
 *                                                @RequestMapping
 *                                                 => GET/POST ����
 *                                                @GetMapping
 *                                                @PostMapping
 *       Spring���� ���� 5���� (�Ի�� => ������) Spring Basic : �������� ���ÿ� �����Ҷ� ����.
 *        ���������� ����� �α� �����̴�.
 *        = DI => 70% �� �����Ұ� (�ٽ�)
 *        = AOP => �ݺ� ���� (�������� Ŭ���� ����)
 *        = ORM => �����ͺ��̽� ���� (MyBatis,JPA,Hibernate)
 *        = MVC
 *        = Security
 *        
 *        1) DI => ����
 *           -- IoC => DI 
 *              --- ������ ���� (��ƾ�Ŀ﷯)
 *              ���� => Ŭ������ Ŭ������ ���� ���踦 ���� (�������� Ŭ���� ���̾�׷� ����)
 *              	   => p:��ü��-ref="id��"
 *                     Ŭ������ �ʿ��� ������ ����
 *                     --------------------
 *                     => p:������="��"
 *                        -----------
 *                        setter / constructor
 *                        --------------------- XML������ ����
 *                        ������̼ǿ����� ����� �Ұ���
 *          Ŭ���� �Ѱ� �޸� �Ҵ� 
 *            <bean>
 *          Ŭ���� ������ �޸� �Ҵ�
 *            <context:component-scan basepackage="">
 *            =>�����ؼ� �޸� �Ҵ� ��û
 *               -------------- �޸𸮿� �Ҵ�� ��ü�� �������� �����Ѵ�.
 *               @Controller : Model Ŭ���� = ��ûó�� => Web
 *               @Component : �Ϲ�Ŭ������ �����Ҷ� => MainClass..
 *               @Repository : ����� => DAO
 *               @Service : BI => ���� (DAO �������� �ѹ��� ���սÿ� �ַ� ���)
 *                          ��) EmpDAO / DeptDAO
 *                             -----------------�����̳� ���������� �ɷ�������
 *               @RestController : �ٸ� ���α׷��̶� �����Ҷ�
 *                                 ---------- ������ ���������δ� �ڹٽ�ũ��Ʈ (JSON ���� ��)
 *                                                           ----------------------
 *                                                           | VueJS
 *               @ControllerAdvice : ���� ����ó�� (�̰� �ɾ�θ� �޼ҵ� ���� �� �ʿ� ���� ������ �� ����ش�)
 *               @RestControllerAdvice : ���� ����ó��
 *               @Bean : �ڹٷ� Ŭ���� ���� ������ ���
 *                 <bean> ������ؼ� ����
 *               ---------------------
 *               Ŭ���� ���� ���߿� �ϳ����־�߸� �޸� �Ҵ��� �Ѵ�.
 *               
 *               3���� ���
 *               1. Ŭ������ �Ѱ��� ����ϴ� ��� <bean>���� ��� / �������� ������ 100���� ���ÿ� ���ٰ� ����غ��� 
 *                    | XML�ڵ�
 *    ���ù�ﳻ��- 2. ��� Ŭ������ �ѹ��� ����ϴ� ��� : ��Ű�� ���� ���
 *                    | ������̼� �ڵ�
 *               3. XML + Annotation ���
 *                   |      | ���� Ŭ���� (=����� ���� Ŭ����)
 *                  XML�� ����Ҷ��� �������� �����ؾ��ϴ� �κе��� ©�� ���� (=���̺귯�� Ŭ����) => DAO / ���� �� ����
 *                  
 *              ��� ���̺귯���� ��� �޾Ƽ� ó���ؾ��Ѵ�?
 *              
 *              ��� XML ������̼� ���� ����� ������.. => com.sist.goods~sawon
 *              
 *              ������̼��� ���Ͱ� �ȵȴ�. �ʱⰪ�� �־�����Ѵ�.
 *              
 *             
 *             �޸� �Ҵ��� �����ؾ� �Ѵ�.  <context:component-scan base-package="com.sist.*"/> �̰͸����δ� �ƹ��͵� �ҷ� �� �� ����
 *             �Ʒ� ó�� ������̼��� �ø��� �޸� �Ҵ��� �ȴ�.
 *             // <bean id="sa" class="com.sist.sawon.SawonManager"/> = @Component("sa") ������ �ڵ�
 *             @Conponent("") ���̵� ������ �� �ְ� @Conponent �̷��� ���̵� �������� �ʴ� ��찡 ����
 *             ���̵� �������� ������ �� ù���ڸ� �ҹ��ڷ� �������� �״�� ���� �ҷ� �� �� �ִ�.
 *             
 *             public void setSawon(Sawon sawon) {
				this.sawon = sawon;
				}
				�� Ŭ������ ���ذ� �Ȱ�
				
				p = property
 */
import com.sist.goods.*;
import com.sist.member.*;
import com.sist.sawon.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ����� XML�� �����̳ʷ� ����
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		//Ŭ���� ã�� -> Ȱ��
		SawonManager sa=(SawonManager)app.getBean("sa");
		sa.display();
		MemberManager mem=(MemberManager)app.getBean("mem");
		mem.display();
		GoodsManager goods=(GoodsManager)app.getBean("goods");
		goods.display();
		// �� ���� �̿��ؾ� ã�� �� �� �ִ�. 
	}

}
