<%@ page contentType="text/html; charset=EUC-KR"%>
<%
	  request.setCharacterEncoding("EUC-KR");
	  String id = (String)session.getAttribute("idKey");
%>
<html>
<head>
<title>�α���</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	function loginCheck() {
		if (document.loginFrm.id.value == "") {
			alert("���̵� �Է��� �ּ���.");
			document.loginFrm.id.focus();
			return;
		}
		if (document.loginFrm.pwd.value == "") {
			alert("��й�ȣ�� �Է��� �ּ���.");
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
			<font color="white"><b><%=id%></b>�� ȯ�� �մϴ�.</font>
			<font color="white"><p>���ѵ� ����� ��� �� ���� �ֽ��ϴ�.</font>
		<%} else{%>
			<font color="white">������ : <b><%=id%></b></font>
			<p><a href="member/memberList.jsp" target="content"><font color="f4ae3f">ȸ����Ϻ���</font></a>
		<%} %>
		<p><a href="member/logout.jsp"><font color="f4ae3f">�α׾ƿ�</font></a>
		
	<%} else {%>
		<form name="loginFrm" method="post" action="member/loginProc.jsp">
			<table>
				<tr>
					<td align="center" colspan="2"><font color="#f4ae3f"><h2>�α���</h2></font></td>
				</tr>
				<tr>
					<td><font color="white">�� �� ��</font></td>
					<td><input name="id" value=""></td>
				</tr>
				<tr>
					<td><font color="white">��й�ȣ</font></td>
					<td><input type="password" name="pwd" value=""></td>
				</tr>
				<tr>
					<td colspan="2">
						<div align="right">
							<input type="button" value="�α���" onclick="loginCheck()">&nbsp;
							<input type="button" value="ȸ������" onClick="memberForm()" >
						</div>
					</td>
				</tr>
			</table>
		</form>
	<%}%>
	</div>
</body>
</html>