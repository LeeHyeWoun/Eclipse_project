<%@ page contentType="text/html; charset=EUC-KR"%>
<%
	  request.setCharacterEncoding("EUC-KR");
	  String id = (String)session.getAttribute("idKey");
%>
<html>
<head>
<title>로그인</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	function loginCheck() {
		if (document.loginFrm.id.value == "") {
			alert("아이디를 입력해 주세요.");
			document.loginFrm.id.focus();
			return;
		}
		if (document.loginFrm.pwd.value == "") {
			alert("비밀번호를 입력해 주세요.");
			document.loginFrm.pwd.focus();
			return;
		}
		document.loginFrm.action = "member/loginProc.jsp";
		document.loginFrm.submit();
	}
	
	function memberForm(){
		document.loginFrm.target = "content";
		document.loginFrm.action = "member/member.jsp";
		document.loginFrm.submit();
	}
</script>
</head>
<body bgcolor="#FFFFCC">
<br/><br/>
	<div align="center">
	<%
		if (id != null) {
	%>
		<%
			if (!id.equals("admin")){
		%>
			<font color="white"><b><%=id%></b>님 환영 합니다.</font>
			<font color="white"><p>제한된 기능을 사용 할 수가 있습니다.</font>
		<%} else{%>
			<font color="white">관리자 : <b><%=id%></b></font>
			<p><a href="member/memberList.jsp" target="content"><font color="f4ae3f">회원목록보기</font></a>
		<%} %>
		<p><a href="member/logout.jsp"><font color="f4ae3f">로그아웃</font></a>
		
	<%} else {%>
		<form name="loginFrm" method="post" action="member/loginProc.jsp">
			<table>
				<tr>
					<td align="center" colspan="2"><font color="#f4ae3f"><h2>로그인</h2></font></td>
				</tr>
				<tr>
					<td><font color="white">아 이 디</font></td>
					<td><input name="id" value=""></td>
				</tr>
				<tr>
					<td><font color="white">비밀번호</font></td>
					<td><input type="password" name="pwd" value=""></td>
				</tr>
				<tr>
					<td colspan="2">
						<div align="right">
							<input type="button" value="로그인" onclick="loginCheck()">&nbsp;
							<input type="button" value="회원가입" onClick="memberForm()" >
						</div>
					</td>
				</tr>
			</table>
		</form>
	<%}%>
	</div>
</body>
</html>