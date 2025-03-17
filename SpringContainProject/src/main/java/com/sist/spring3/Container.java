package com.sist.spring3;
import java.util.*;
public class Container {
	private Map clsMap=new HashMap();
	// 팩토리 패턴 => 싱글턴 패턴을 사용중이다.
	// 단순한 관계(경량)로 바뀐다 / 메모리 누수현상을 방지해준다
	public Container()
	{
		clsMap.put("a", new A());
		clsMap.put("b", new B());
		clsMap.put("c", new C());
	}
	public I getBean(String key)
	return (I)clsMap.get(key);
}
