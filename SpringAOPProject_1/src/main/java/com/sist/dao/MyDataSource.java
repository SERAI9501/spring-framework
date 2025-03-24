package com.sist.dao;

import lombok.Data;
// BasicDataSource
// 데이터 베이스 정보와 관련된 데이터를 가진 애
@Data
public class MyDataSource {
	private String driver;
	private String url,username,password;
}
