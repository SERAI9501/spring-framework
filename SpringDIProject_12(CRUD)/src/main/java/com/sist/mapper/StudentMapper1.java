package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;
public interface StudentMapper1 {
	/*
	 * <select id="studentListData" resultType="StudentVO">
    SELECT * FROM student
   </select>
   <select id="studentDetailData" resultType="StudentVO" parameterType="int">
	SELECT * FROM student 
	WHERE hakbun=#{hakbun}
   </select>
	 */
	@Select("SELECT * FROM student")
	public List<StudentVO> studentListData();
	
	@Select("SELECT * FROM student "
			+ "WHERE hakbun=#{hakbun}")
	public StudentVO studentDetailData(int hakbun);
	/*
	 *  <insert id="studentInsert" parameterType="StudentVO">
   <!-- 누구것을 증가시킬 거냐 = keyProperty 
       keyProperty먼저 수행하고 즉 증가된 값을 증가하고 뒤에  VALUES 값을 채워준다-->
    <selectKey keyProperty="hakbun" resultType="int" order="BEFORE">
     SELECT NVL(MAX(hakbun)+1,1) as hakbun FROM student
    </selectKey>
     INSERT INTO student VALUES()
     #{hakbun},#{name},#{kor},#{eng},#{math}
   </insert>
	 */
	
	@SelectKey(keyProperty = "hakbun",
			resultType = int.class, before = true,
			statement = "SELECT NVL(MAX(hakbun)+1,1) as hakbun FROM student")
	// Sequence / subquery / NVL..MAX.. 이 셋중에 하나를 쓰면 된다.
	@Insert("INSERT INTO student VALUES( "
		     + "#{hakbun},#{name},#{kor},#{eng},#{math})")
	public void studentInsert(StudentVO vo);
	/*<delete id="studentDelete" parameterType="int">
    DELETE FROM student
    WHERE hakbun=#{hakbun}
   </delete>
	 * 
	 */
	@Delete("DELETE FROM student "
			+ "WHERE hakbun=#{hakbun}")
	public void studentDelete(int hakbun);
	/*<update id="studentUpdate" parameterType="StudentVO">
    UPDATE student SET
    name=#{name},kor=#{kor},eng=#{eng},math=#{math}
    WHERE hakbun=#{hakbun}
   </update>
	 * 
	 */
	@Update("UPDATE student SET "
			+ "name=#{name},kor=#{kor},eng=#{eng},math=#{math} "
			+ "WHERE hakbun=#{hakbun}")
	public void studentUpdate(StudentVO vo);
}
