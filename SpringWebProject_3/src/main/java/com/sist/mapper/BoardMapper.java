package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;

public interface BoardMapper {
	@Select("SELECT no,subject,name,hit,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,num "
			+ "FROM (SELECT no,subject,name,hit,regdate,rownum as num "
			+ "FROM (SELECT no,subject,name,hit,regdate "
			+ "FROM freeboard ORDER BY no DESC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<BoardVO> boardListData(
			@Param("start") int start,
			@Param("end") int end);
	//해쉬맵은 키 가지고 구분 할 수 있다 / vo는 갯내임으로 구분가능한데 위는 구분할 수 없어서 파람을 사용한다.
	@Select("SELECT CEIL(COUNT(*)/10.0) FROM freeboard")
	public int boardTotalPage();
	// 상세보기
	@Update("UPDATE freeboard SET "
			+ "hit=hit+1 "
			+ "WHERE no=#{no}")
	public void hitIncrement(int no);
	@Select("SELECT no,name,subject,content,hit,TO_CHAR(regdate,'YYYY-MM-DD') as dbday "
			+ "+FROM freeboard "
			+ "WHERE no=#{no}")
	public BoardVO boardDetailData(int no);
	/*
	 * 리턴형 = resultType , 매개변수 = parameterType
	 * 메소드명 = ID
	 *  <select id="empListData" resultYype="EmpVO"
	 *  parameterType="hashmap">
	 *  SELECT * FROM emp => 여기서 실행하는값이 로우가 몇개냐가 중요하다 row가 여러개이면 리턴형은 List로 row가 하나면 EmpVO로 받아야 한다. 
	 *  WHERE num BETWEEN #{start} AND #{end}
	 *  </select>
	 *  public List<EmpVO> empListData(Map map)
	 *         ===========
	 *          selectList / selectOne
	 *  xml을쓰면 단점이 xml에 등록해야해서 여러명이 쓰기 힘들어진다.
	 *  => 등록 없이 개발자 각자 처리 = 어노테이션
	 *  => application.xml 없어지고 자바로 환경설정으로 변견된다.
	 *     
	 */
	// Spring-Boot => MySQL + JPA를 스프링 부트로 가면 마이SQL + JPA를 배운다
	// MySQL 
	// 추가
	@Insert("INSERT INTO freeboard VALUES("
			+ "SELECT NVL(MAX(no)+1,1) FROM freeboard),"
			+ "#{name}.#{subject},#{content},#{pwd},"
			+ "SYSDATE,0)")
	public void boardInsert(BoardVO vo);
	// 수정
	@Select("SELECT pwd FROM freeboard "
			+ "WHERE no=#{no}")
	public String boardGetPassword(int no);
	
	@Update("UPDATE freeboard SET "
			+ "name=#{name},subject#{subject},"
			+ "content=#{content}"
			+ "WHERE no=#{no}")
	public void boardUpdate(BoardVO vo);
	// 삭제
	@Delete("DELETE FROM freeboar "
			+ "WHERE no=#{no}")
	public void boardDelete(int no);
}
