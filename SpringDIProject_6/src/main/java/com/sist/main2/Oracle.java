package com.sist.main2;

import org.springframework.stereotype.Component;

@Component
public class Oracle implements DAO{

	@Override
	public void connection() {
		// TODO Auto-generated method stub
		System.out.println("����Ŭ ����");
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		System.out.println("����Ŭ ����");
	}

}
