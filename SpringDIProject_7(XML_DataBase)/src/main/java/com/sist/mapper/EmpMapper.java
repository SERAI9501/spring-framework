package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.EmpVO;
public interface EmpMapper {
	/*
	 * <select id="empListData" resultType="EmpVO">
	 *  SELECT empno,enmae,job.,sal,TO_CHAR(hiredate,'YYYY-MM-DD")
	 *  FROM emp
	 * </select>
	 * 아래 처럼 바뀐다
	 * @Select("SELECT empno,enmae,job.,sal,TO_CHAR(hiredate,'YYYY-MM-DD")
	 *  FROM emp")
	 *  public List<EmpVO> empListData(); => 자동 구현이 된다. 
	 */
	@Select("SELECT empno,ename,job,sal,"
			   +"TO_CHAR(hiredate,'YYYY-MM-DD') as dbday "
			   +"FROM emp")
		public List<EmpVO> empListData();
		//     resultType     id      parameterType
		//     ==> 매개변수를 여러개 사용이 가능 
	}