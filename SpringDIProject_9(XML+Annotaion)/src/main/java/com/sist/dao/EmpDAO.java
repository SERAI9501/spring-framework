package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.EmpMapper;
import com.sist.vo.*;

import oracle.net.aso.m;
@Repository("eDao")
public class EmpDAO {
	@Autowired
	private EmpMapper mapper;
	public List<EmpVO> empListData()
	{
		return mapper.empListData();
	}
}
