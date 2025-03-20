package com.sist.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sist.vo.FoodVO;

public interface FoodService {
	//public List<FoodVO> foodListData(@Param("start") int start,@Param("end") int end);
	/*
	 * 마이바티스에서만 파람을 쓴다.
	 */
	public List<FoodVO> foodListData(int start,int end);
	public int foodTotalPage();
}
