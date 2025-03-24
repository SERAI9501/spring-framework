package com.sist.web;

import org.springframework.web.bind.annotation.RestController;
//@ResponseBody 메소드였는데 => @RestController로 클래스형으로 승격됬다. Ajax / Vue / React연동할때 쓰인다.
//JSON이 있으면 연동을 할때 쓴다. 모바일,파이썬 등 다양한 언어와 연동이 가능하게 해준다.
//언어마다 똑같은 포맷을 가지기 때문에 사용하기 편리하다

@RestController //화면이동은 하지 못하고 데이터 전송 목적이다
// => 자바스크립트 전송이 가능하다
public class BoardRestController {

}
