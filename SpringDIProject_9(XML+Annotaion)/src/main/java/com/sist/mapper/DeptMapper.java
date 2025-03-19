package com.sist.mapper;

import org.apache.ibatis.annotations.Select;
import java.util.*;
import com.sist.vo.*;
public interface DeptMapper {
	@Select("SELECT * FROM dept")
	public List<DeptVO> deptListData();
}
