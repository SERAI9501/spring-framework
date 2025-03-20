package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface EmpMapper {
   @Select("SELECT empno,ename,job,sal,TO_CHAR(hiredate,'YYYY-MM-DD') as dbday "
		  +"FROM emp")
   public List<EmpVO> empListData();
   
   @Select("SELECT empno,ename,job,sal,TO_CHAR(hiredate,'YYYY-MM-DD') as dbday "
			  +"FROM emp "
			  +"WHERE empno=#{empno}")
   public EmpVO empDetailData(int empno);
   //아이디 리절트타입 파라미터타입
   /*
    * <select id="empDetailData" resultType="EmpVO" parameterType="int">
    * "SELECT empno,ename,job,sal,TO_CHAR(hiredate,'YYYY-MM-DD') as dbday "
   		+ "FROM emp"
   		+ "WHERE empno=#{empno}")
    * </select>
    */
   /*
    * <resultMap type="" id="">
    *  <result property="" column=""/>
    * </resultMap>
    * 
    * 밑에는 어노테이션만 걸때 쓰는 것
    */
   @Results({
	   @Result(property = "dvo.dname",column = "dname"), //조인 걸었을때 컬럼을 확정하는 과정
	   @Result(property = "dvo.loc",column = "loc")
   })
   @Select("SELECT empno,ename,job,sal,dname,loc "
			  +"FROM emp,dept "
			  +"WHERE emp.deptno=dept.deptno")
   public List<EmpVO> empJoinData();
}
