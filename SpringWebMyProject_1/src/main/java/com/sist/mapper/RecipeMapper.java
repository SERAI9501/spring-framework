package com.sist.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.*;
import com.sist.vo.*;

public interface RecipeMapper {
	/*
   private int no,hit,replycount,likecount;
   private String title,poster,chef,link;
	 */
	@Select("SELECT no,hit,replycount,likecount,title,poster,chef,link,num "
			+ "FROM (SELECT no,hit,replycount,likecount,title,poster,chef,link,rownum as num "
			+ "FROM (SELECT /*+ INDEX_ASC(recipe r_no_pk)*/no,hit,replycount,likecount,title,poster,chef,link "
			+ "FROM recipe)) "
			+ "WHERE num BETWEEN {start} AND {end}")
	public List<RecipeVO> recipeListData(Map map);
	
	@Select("SELECT * FROM recipe"
			+ "WHERE no=#{no} ")
	public RecipeVO recipeDetailData(int no);
	
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM recipe")
	public int recipeTotalPage();
	
	@Update("UPDATE recipe SET "
			+ "hit=hit+1 "
			+ "WHERE no=#{no}")
	public void recipeHitIncrement(int no);
}
