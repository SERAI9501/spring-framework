package com.sist.vo;
/*
 * 1.동작 방법 / 사용법
 * 2. 데이터베이스 연동 => 화면
 * ----------------------- 반복
 */

import java.util.*;

import lombok.Data;
//게시판은 필수다. => CRUD 가 들어가있기 때문이다.
@Data
public class BoardVO {
	private int no,hit;
	private String name,subject,content,pwd,dbday;
	private Date regdate;	
}
