package com.sist.vo;

import lombok.Data;
// 반드시 변수명과 일치해야만 자동으로 값이 들어간다.
@Data
public class SawonVO {
	private int sabun;
	private String name,dept,job,loc;
	private int pay;
}
