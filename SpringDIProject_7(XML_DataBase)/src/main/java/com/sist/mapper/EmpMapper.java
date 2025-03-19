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
	 * �Ʒ� ó�� �ٲ��
	 * @Select("SELECT empno,enmae,job.,sal,TO_CHAR(hiredate,'YYYY-MM-DD")
	 *  FROM emp")
	 *  public List<EmpVO> empListData(); => �ڵ� ������ �ȴ�. 
	 */
	@Select("SELECT empno,ename,job,sal,"
			   +"TO_CHAR(hiredate,'YYYY-MM-DD') as dbday "
			   +"FROM emp")
		public List<EmpVO> empListData();
		//     resultType     id      parameterType
		//     ==> �Ű������� ������ ����� ���� 
	}