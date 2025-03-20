package com.sist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.FoodDAO;
import com.sist.vo.FoodVO;
/*
 *  DAO�� �����ϰ� DB���Ḹ �Ѵ�.
 *  
 *  ���� ���� ����ϴ� ������ ���� ���񽺰� �Ѵ�.
 *  ���񽺰� ��� �����͸� �޾Ƽ� ����� ó���Ѵ�. 
 *  service�� BI��� �Ѵ� �����Ͻ� ����
 *  
 *  ���� �����ϰ� setAttribute�� �Ѵ�.
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
