package com.sist.spring;
import java.lang.reflect.Method;
import java.util.*;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/*
 *   XML 파싱
 *     =DOM
 *      속도가 늦다 => 메모리 트리 형태로 저장 / DML=CRUD가 가능하다
 *     =SAX : MyBatis / Spring
 *      속도가 빠르다 => 태그의 값/속성 값만 읽기
 *      읽기만 한다 저장을 하지 않는다.
 *      
 *      이벤트
 *      <?xml version="1.0" encoding="UTF-8"?> startDocument
		<beans> startElement()
		 <bean id="sa" class="com.sist.spring.Sawon"> startElement()
		  <property name="name" value="홍길동"/>
		startElement()                 endElement()
		  <property name="sex" value="남자"/>
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
			if(qName.equals("bean")) // 클레스를 저장하는 과정 = 메모리 할당해서 저장하는 과정
			{
				String id=attributes.getValue("id");
				String cls=attributes.getValue("class");
				clsName=Class.forName(cls);
				obj=clsName.getDeclaredConstructor().newInstance();
				// 클래스이름으로 제어 (변수주입 , 객체 생성 / 메소드 호출)
				clsMap.put(id, obj); // 사용할때 형변환 한다.
			}

			// DI => setter DI
			if(qName.equals("property"))//멤버 변수에 값을 채워준다.
			{
				String name=attributes.getValue("name");
				String value=attributes.getValue("value");
				// Method 호출 => setName setSex setAge
				Method[] methods=clsName.getDeclaredMethods(); //위 클래스 안에 있는 모든 메소드를 가져와라 겟터세터 6개에 프린트1개 총 7개
				for(Method m:methods)
				{
					if(m.getName().equalsIgnoreCase("set"+name))//이그노어 케이스로 대소문자 구분없이 찾겠다
					{
						if(name.equals("age"))
						{
							m.invoke(obj, Integer.parseInt(value));
						}
						else
						{
							m.invoke(obj, value);
							// sa.setName("홍길동") 위과정과 똑같다
						}
					}
				}
			}
		}catch (Exception ex) {}
	}
	
	
}
