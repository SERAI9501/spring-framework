package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;

import oracle.net.aso.m;
@Repository
public class BoardDAO {
	private BoardMapper mapper;
/*
 * @Select("SELECT no,subject,name,hit,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,num "
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
 */
	public List<BoardVO> boardListData(int start,int end)
	{
		return mapper.boardListData(start, end);
	}
	public int boardTotalPage()
	{
		return mapper.boardTotalPage();
	}
	public void boardInsert()
	{
		return mapper.boardInsert(null);
	}
}
