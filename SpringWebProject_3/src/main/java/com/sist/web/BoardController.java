package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
/*
 *  Mapper => 스프링에서 구현
 *  ---------------------
 *          |
 *        BoardDAO
 *          |
 *        Model => JSP
 *        
 *        1.request는 보안문제로 사용 금지
 *          --------
 *          1) 요청값 받기 ==> 매개변수로 변경되었다
 *                          ------ 순서랑 상관이 없다
 *                                 => 처리하는 내장 객체를 받아서 처리
 *                                 request/response/session
 *                                 RedirectAttributes
 *                                 => VO
 *                                 대신 어느상황에 위에 것들을 잘 가져와야 하는지 알아야한다.
 *          2) JSP로 값을 전송 ==> Model로 변경되었다.
 *          
 *         2. 기본 틀 => 메인보드 역할을 수행하는 것 Spring
 *                      ------ 부품 제작 (CPU/하드디스크) 이런역할을 수행하는것이 개발자
 *            DispatcherServlet : 요청 / 응답
 *              => web.xml에 등록
 *            HandlerMapping    : Model을 찾아주는 역할
 *                                @RequestMapping을 찾아서 
 *                                메소드 호출 
 *                                => 자동으로 셋팅된다.
 *            ViewResolver      : 결과값(request)를 JSP로 전송
 *                                =>jsp에서 찾으려면 경로명 / 확장자가 필요하다
 *                                =>application-context.xml에 등록할 예정
 *          3. JSP는 변경 사항이 없다
 *          
 *       => 가장먼저 해야할 것 
 *          1.매개변수를 어떻게 처리할지
 *          2. request를 전송 할지 말지(내가 포워드를 쓸지 센드리다이렉트를 쓸지)
 *            전송 할 때가 있고 없을때가 있다. 전송할때는 return "jsp파일명" 을 지정해야한다. = forwoard기법이라 한다
 *                                  반대는 return "redirect:"
 *                                        sendredirect = 이동만 한다
 *          3.DB만 잘 설정
 *          
 *         1. 동작 순서
 *         	  사용자 전송 => 요청 받아서 => Model로 요청값 전송 => 데이터베이스 연동
 *            => 요청 처리 => 결과값을 => JSP로 전송
 *            
 *            jsp(forword) => 결과값 전송이 있는 경우
 *            jsp(redirect) => 결과값이 없는 상태 => 기존의 화면이동
 *            
 *            detail.do = detail.jsp
 *            insert_ok.do = list.jsp
 *            update_ok.do = detail.jsp
 */
@Controller
@RequestMapping("board/")
public class BoardController {
	@Autowired
	private BoardDAO dao;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@RequestMapping("list.do")
	public String board_list(String page,Model model)
	{	
		if(page==null)
			page="1";
		
		int curpage=Integer.parseInt(page);
		List<BoardVO> list=dao.boardListData((10*curpage)-9, curpage*10);
		int totalpage=dao.boardTotalPage();
		
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("list",list);
		return "board/list";
	}
	@RequestMapping("insert.do")
	public String board_insert()
	{
		
		return "board/insert";
	}
	@RequestMapping("insert_ok.do")
	public String board_insert_ok(BoardVO vo)
	{
		String pwd=encoder.encode(vo.getPwd());
		vo.setPwd(pwd);
		System.out.println("pwd="+pwd);
		dao.boardInsert(vo);
		// => if(pwd.matchs(vo.getPwd());
		
		return "redirect:list.do";
	}
	//상세보기 요청
	@RequestMapping("detail.do")
	// 데이터형 => String 통합 , 각 데이터형으로 받을 수 있다
	// 맨처음에 시작할때 데이가 없는 경우도 있다 예를 들어 page 가 있다 이런경우에는 => String으로 받는다
	public String board_detail(int no,Model model)
	{
		/*
		 * Model => 전송객체 : request를 대체
		 * =>Cookie
		 */
		BoardVO vo=dao.boardListData(no);
		model.addAttribute("vo",vo);
		return "board/detail";
	}
	
	// 수정 / 삭제 => 비번 검색
	/*
	 * 리턴형으로 쓸 수 있는애
	 *	String  : 파일명 지정 / .do
	 *	void => 다운로드 
	 * 매개변수로 사용 할 수 있는애
	 *   일반데이터형
	 *   배열
	 *   List
	 *   VO
	 *   내장 객체 : request, response,session
	 *             보안 객체 / RedirectAttributes
	 */
	@RequestMapping("update.do")
	public String board_update(int no,Model model)
	{
		return "board/update";
		
	}
	
	/*@RequestMapping("update_ok.do")
	public String board_update_ok(BoardVO vo,Model model)
	{
		boolean bCheck=dao.boardListData(vo);
		model.addAttribute("bCheck",bCheck);
		model.addAttribute("no",vo.getNo());
		
		return "board/update_ok";
	}*/
	
	/*@RequestMapping("update_ok.do")
	@ResponseBody() => 승격
	// out.write() => 자바스크립트 전송 , JSON , 일반 문자열 전송
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
	}*/
	//delete.do?no=${vo.no } => 매개변수로 가져와야 한다. // 데이터형이 다른 경우 400 Bad request
	@RequestMapping("delete.do")
	public String board_delete(int no,Model model)
	{
		model.addAttribute("no", no);
		return "board/delete.jsp";
	}
}
