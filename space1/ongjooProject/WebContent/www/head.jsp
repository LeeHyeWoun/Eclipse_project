<%@ page contentType="text/html; charset=EUC-KR" %>
<%
	  String id = (String) session.getAttribute("idKey");
	  String cPath = request.getContextPath();
	  String url = "member/member.jsp";
	  String label = "회원가입";
      if(id!=null){
        url = "member/memberUpdate.jsp";
        label = "회원수정";
      }
%>
<html>
<head>
<title>head</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body  bgcolor="#f0e6d7">
	<table width="1280" cellpadding="0" cellspacing="0">
		<tr>
			<td colspan="5">
				<a href="<%=cPath%>/www/index.jsp" target="_parent" onFocus="this.blur();">
				<img src="images/myLogo.png" border="0" style="max-width: auto; height: 90;"></a>
			</td>
		</tr>
		<tr>
			<td width="400">&nbsp;</td>
			<td><font size="3"><a href="<%=url%>" target="content"><b><%=label%></b></a></font></td>
			<td><font size="3"><a href="board/list.jsp" target="content"><b>게시판1</b></a></font></td>
			<td><font size="3"><a href="board/list2.jsp" target="content"><b>게시판2</b></a></font></td>
			<!--<td><font size="3"><a a href="poll/pollList.jsp" target="content"><b>투표프로그램</b></a></font></td>-->
		</tr>
	</table>
</body>
</html>