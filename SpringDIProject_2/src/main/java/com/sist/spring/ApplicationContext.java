package com.sist.spring;
import java.io.*;
import java.util.*;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
public class ApplicationContext {
	private Map map=new HashMap();
	public ApplicationContext(String path)//생성자는 퍼블릭을 줘야한다
	{
		try
		{
			SAXParserFactory spf=SAXParserFactory.newInstance();
			SAXParser sp=spf.newSAXParser();//객체 생성
			XMLParser xp=new XMLParser();
			sp.parse(new File(path),xp);
			map=xp.clsMap;
		}catch(Exception ex) {}
	}
	public Object getBean(String key)
	{
		return map.get(key);
	}
}
