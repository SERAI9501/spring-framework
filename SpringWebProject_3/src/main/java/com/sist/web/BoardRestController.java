package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sist.dao.*;
import com.sist.vo.*;
//@ResponseBody 메소드였는데 => @RestController로 클래스형으로 승격됬다. Ajax / Vue / React연동할때 쓰인다.
//JSON이 있으면 연동을 할때 쓴다. 모바일,파이썬 등 다양한 언어와 연동이 가능하게 해준다.
//언어마다 똑같은 포맷을 가지기 때문에 사용하기 편리하다

@RestController //화면이동은 하지 못하고 데이터 전송 목적이다
// => 자바스크립트 전송이 가능하다 => JSON / JavaScript 전송
public class BoardRestController {
	@Autowired
	private BoardDAO dao;
	
	@RequestMapping(value = "board/update_ok.do",produces = "text/html;charset=UTF-8")
	public String board_update_ok(BoardVO vo)
	{
		String result="";
		boolean bCheck=dao.boardUpdate(vo);
		if(bCheck==true)
		{
			result="<script>"
					+ "location.href=\"detail.do?no="+vo.getNo()+"\"
					+ "</script>";
		}
		else
		{
			result="<script>"
					+ "alert(\"Password Fail!!\");"
					+ "history.back();"
					+ "</script>";
		}
		return result;
	}
	@RequestMapping(value = "board/delete_ok.do",produces = "text/html;charset=UTF-8")
	public String board_delete_ok(int no,String pwd)
	{
		String result="";
		boolean bCheck=dao.boardDelete(vo);
		if(bCheck==true)
		{
			result="<script>"
					+ "location.href=\"detail.do?no="+vo.getNo()+"\"
					+ "</script>";
		}
		else
		{
			result="<script>"
					+ "alert(\"Password Fail!!\");"
					+ "history.back();"
					+ "</script>";
		}
		return result;
	}
}
