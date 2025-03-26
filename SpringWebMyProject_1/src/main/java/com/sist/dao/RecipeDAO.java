package com.sist.dao;

import java.util.List;
import java.util.Map;
import com.sist.mapper.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.RecipeVO;
@Repository
public class RecipeDAO {
	@Autowired
	private RecipeMapper mapper;
	public List<RecipeVO> recipeListData(Map map)
	{
		return mapper.recipeListData(map);
	}
	public int recipeTotalPage()
	{
		return mapper.recipeTotalPage();
	}
	public void recipeHitIncrement(int no)
	{
		mapper.recipeHitIncrement(no);
		return mapper.recipeHitIncrement(no);
	}
}
