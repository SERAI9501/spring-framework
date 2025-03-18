package com.sist.spring;
import java.lang.reflect.Method;
import java.util.*;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/*
 *   XML �Ľ�
 *     =DOM
 *      �ӵ��� �ʴ� => �޸� Ʈ�� ���·� ���� / DML=CRUD�� �����ϴ�
 *     =SAX : MyBatis / Spring
 *      �ӵ��� ������ => �±��� ��/�Ӽ� ���� �б�
 *      �б⸸ �Ѵ� ������ ���� �ʴ´�.
 *      
 *      �̺�Ʈ
 *      <?xml version="1.0" encoding="UTF-8"?> startDocument
		<beans> startElement()
		 <bean id="sa" class="com.sist.spring.Sawon"> startElement()
		  <property name="name" value="ȫ�浿"/>
		startElement()                 endElement()
		  <property name="sex" value="����"/>
		  <property name="age" value="25"/>
		 </bean> endElement()
		</beans> endElement()
		endDocument()
 */

public class XMLParser extends DefaultHandler{
	Map clsMap=new HashMap();
	Object obj;
	Class clsName;
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		try
		{
			if(qName.equals("bean")) // Ŭ������ �����ϴ� ���� = �޸� �Ҵ��ؼ� �����ϴ� ����
			{
				String id=attributes.getValue("id");
				String cls=attributes.getValue("class");
				clsName=Class.forName(cls);
				obj=clsName.getDeclaredConstructor().newInstance();
				// Ŭ�����̸����� ���� (�������� , ��ü ���� / �޼ҵ� ȣ��)
				clsMap.put(id, obj); // ����Ҷ� ����ȯ �Ѵ�.
			}

			// DI => setter DI
			if(qName.equals("property"))//��� ������ ���� ä���ش�.
			{
				String name=attributes.getValue("name");
				String value=attributes.getValue("value");
				// Method ȣ�� => setName setSex setAge
				Method[] methods=clsName.getDeclaredMethods(); //�� Ŭ���� �ȿ� �ִ� ��� �޼ҵ带 �����Ͷ� ���ͼ��� 6���� ����Ʈ1�� �� 7��
				for(Method m:methods)
				{
					if(m.getName().equalsIgnoreCase("set"+name))//�̱׳�� ���̽��� ��ҹ��� ���о��� ã�ڴ�
					{
						if(name.equals("age"))
						{
							m.invoke(obj, Integer.parseInt(value));
						}
						else
						{
							m.invoke(obj, value);
							// sa.setName("ȫ�浿") �������� �Ȱ���
						}
					}
				}
			}
		}catch (Exception ex) {}
	}
	
	
}
