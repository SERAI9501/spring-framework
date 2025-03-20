package com.sist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.FoodDAO;
import com.sist.vo.FoodVO;
/*
 *  DAO는 순수하게 DB연결만 한다.
 *  
 *  전에 모델이 담당하는 역할을 이젠 서비스가 한다.
 *  서비스가 모든 데이터를 받아서 기능을 처리한다. 
 *  service를 BI라고 한다 비지니스 로직
 *  
 *  모델은 순수하게 setAttribute만 한다.
 *  
 */
@Service
public class FoodServiceImpl implements FoodService{
	@Autowired
	private FoodDAO fDao;
	
	public List<FoodVO> foodListData(int start,int end)
	{
		return fDao.foodListData(start, end);
	}
	public int foodTotalPage()
	{
		return fDao.foodTotalPage();
	}
}
