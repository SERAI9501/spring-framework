package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
	// 추가
	@Insert("INSERT INTO freeboard VALUES("
			+ "SELECT NVL(MAX(no)+1,1) FROM freeboard),"
			+ "#{name}.#{subject},#{content},#{pwd},"
			+ "SYSDATE,0)")
	public void boardInsert(BoardVO vo);
	// 수정
	// 삭제
}
