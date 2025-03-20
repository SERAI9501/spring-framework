package com.sist.vo;
import java.util.*;

import lombok.Data;
@Data
public class EmpVO {
	private int empno,sal;
	private String ename,job,dbday;
	private Date hiredate;
	private DeptVO dvo=new DeptVO(); // 조인이나 서브쿼리 걸려있을때 사용
}
