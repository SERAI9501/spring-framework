<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
 margin-top: 50px;
}
.row{
  margin: 0px auto;
  width: 800px;
}
</style>
</head>
<body>
  <div class="container">
    <div class="row">
      <h3>내용보기</h3>
      <table class="table">
        <tr>
          <th width="20%" class="text-center">번호</th>
          <td width="30%" class="text-center">${vo.no }</td>
          <th width="20%" class="text-center">작성일</th>
          <td width="30%" class="text-center">${vo.dbday }</td>
        </tr>
        <tr>
          <th width="20%" class="text-center">이름</th>
          <td width="30%" class="text-center">${vo.name }</td>
          <th width="20%" class="text-center">조회수</th>
          <td width="30%" class="text-center">${vo.hit }</td>
        </tr>
        <tr>
          <th width="20%" class="text-center">제목</th>
          <td colspan="3">${vo.subject }</td>
        </tr>
        <tr>
         <td colspan="4" class="text-left" valign="top"></td>
          <pre style="white-space: pre wrap"></pre>
        </tr>
        <tr>
         <td colspan="4" class="text-right">
          <a href="update.do?no=${vo.no }" class="btn btn-xs btn danger">수정</a>
          <a href="delete.do?no=${vo.no }" class="btn btn-xs btn danger">삭제</a>
          <a href="list.do" class="btn btn-xs btn danger">목록</a>
        </tr>
      </table>
    </div>
  </div>
</body>
</html>