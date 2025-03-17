package com.sist.spring2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class EmpDAO {
	@Autowired
	private EmpMapper mapper;
	
	public void setMapper(EmpMapper mapper) {
		this.mapper = mapper;
	}
	public List<EmpVO> empListData(){
		return mapper.empAllData();
	}
}
