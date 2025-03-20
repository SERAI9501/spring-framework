package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;

public interface FoodMapper {
	//목록
	@Select("SELECT fno,name,type,num "
			+ "FROM (SELECT fno,name,type,rownum as num "
			+ "FROM (SELECT fno,name,type "
			+ "FROM project_food ORDER BY fno ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodListData(@Param("start") int start,@Param("end") int end);
	// 메모리는 빈 공백에 채우기 때문에 순차적이지 않다. 그래서 
	/*
	 * 메모리가 처음에 모두다 빈 공백이면 순차적으로 들어가서 상관없으나
	 * 중간중간 해제되고 빈 공백이 생긴다 그래서 중간에 위가 비거나 아래가 빈다.
	 * 읽어들일때는 순차적으로 위부터 읽어서 어느게 가장 먼저 값이 들어갔을지 알 수 없다.
	 * 매개변수 여러개를 줄 수 있는데 앞에 명칭과 파람스를 줘서 명칭을 일치시켜준다.
	 * 매개변수 집어넣을 때 JPA는 파람을 사용한다.
	 */
	//#{start} =vo.get메소드 들어감
	//public List<FoodVO> foodListData(Map map);도 가능한데
	@Select("SELECT CEIL(COUNT(*)/10.0) FROM project_food")
	public int foodTotalPage();
	
}
