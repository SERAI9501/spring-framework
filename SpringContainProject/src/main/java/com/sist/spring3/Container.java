package com.sist.spring3;
import java.util.*;
public class Container {
	private Map clsMap=new HashMap();
	// ���丮 ���� => �̱��� ������ ������̴�.
	// �ܼ��� ����(�淮)�� �ٲ�� / �޸� ���������� �������ش�
	public Container()
	{
		clsMap.put("a", new A());
		clsMap.put("b", new B());
		clsMap.put("c", new C());
	}
	public I getBean(String key)
	return (I)clsMap.get(key);
}
