package com.sist.vo;
/*
 * HAKBUN NOT NULL NUMBER       
NAME   NOT NULL VARCHAR2(50) 
KOR             NUMBER       
ENG             NUMBER       
MATH            NUMBER      
 */
import java.util.*;

import lombok.Data;
@Data
public class StudentVO {
	private int hakbun,kor,eng,math;
	private String name;
}
