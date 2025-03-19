package com.sist.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.EmpMapper;
import com.sist.vo.EmpVO;

/*
 	<bean id="dao" class="com.sist.dao.EmpDAO"
	 	p:mapper-ref="mapper"
	/>
	라이브러리로 만들기 위해서 상속 받아서 사용함..
	리포지토리랑 컴포넌트가 주가된다.
	
	직접 만든건 객체 단위로 받아야 한다.
	mapper.값을 가져와야함
 */
@Repository
public class EmpDAO {
  @Autowired
  private EmpMapper mapper;
  
  
  public List<EmpVO> empListData();
  {
	return mapper.empListData(); 
  }
  public EmpVO empDetailData(int empno);
  {
	return mapper.empDetailData(empno);  
  }
}
