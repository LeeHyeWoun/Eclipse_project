<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ page import="www.BoardBean"%>
<% 
	int num = Integer.parseInt(request.getParameter("num"));
	String board = request.getParameter("board");
	String nowPage = request.getParameter("nowPage");
	BoardBean bBean = (BoardBean)session.getAttribute("bBean");
	String subject = bBean.getSubject();
	String name = bBean.getName(); 
	String content = bBean.getContent(); 
%>
<html>
<head> 
<title>JSPBoard</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script>
	function check() {
	   if (document.updateFrm.pass.value == "") {
		 alert("수정을 위해 패스워드를 입력하세요.");
		 document.updateFrm.pass.focus();
		 return false;
		 }
	   document.updateFrm.submit();
	}
</script>
</head>
<body bgcolor="#f9f1e5">
<div align="center">
<br><br>
<table width="460" cellspacing="0" cellpadding="3">
  <tr>
   <td bgcolor="#FF9018"  height="21" align="center">수정하기</td>
  </tr>
</table>
<form name="updateFrm" method="post" action="updateProc.jsp?board=<%=board%>" >
<table width="70%" cellspacing="0" cellpadding="7">
 <tr>
  <td align="center">
   <table border="0">
    <tr>
     <td width="20%">성 명</td>
     <td width="80%">
	  <input type="text" name="name" value="<%=name%>" size="30" maxlength="20">
	 </td>
	</tr>
	<tr>
     <td width="20%">제 목</td>
     <td width="80%">
	  <input type="text" name="subject" size="50" value="<%=subject%>" maxlength="50">
	 </td>
    <tr>
     <td width="20%">내 용</td>
     <td width="80%">
	  <textarea name="content" rows="10" cols="50"><%=content%></textarea>
	 </td>
    </tr>
	<tr>
     <td width="20%">비밀 번호</td> 
     <td width="80%"><input type="password" name="pass" size="15" maxlength="15">
      수정시에는 비밀번호가 필요합니다.</td>
    </tr>
	<tr>
     <td colspan="2" height="5"><hr size="1"></td>
    </tr>
	<tr>
     <td colspan="2">
	  <input type="button" value="수정완료" onClick="check()">
      <input type="reset" value="다시수정"> 
      <input type="button" value="뒤로" onClick="history.go(-1)">
	 </td>
    </tr> 
   </table>
  </td>
 </tr>
</table>
 <input type="hidden" name="nowPage" value="<%=nowPage %>">
 <input type='hidden' name="num" value="<%=num%>">
</form> 
</div>
</body>
</html>