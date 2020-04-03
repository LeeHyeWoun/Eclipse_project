<%@ page contentType="text/html; charset=EUC-KR"%>
<%@page import="java.util.*"%>

<%request.setCharacterEncoding("EUC-KR");%>

<jsp:useBean id="mMgr" class="www.MemberMgr"/>

<%
	String ID = request.getParameter("id");
	
	String message = "";

	if(ID!=null){
		boolean result = mMgr.deleteMember(ID);
		if(result){
			message = "탈퇴가 정상적으로 처리되었습니다.";
%>
<script>
	alert("<%=message%>");
	location.reload(); 
	location.href="logout.jsp?id=<%=ID%>";
</script>
<%		}else{%>
<script type="text/javascript">
		alert("회원탈퇴에 실패하였습니다.");
		history.back();
</script>
<%		}} else{%>
<script>
	alert("삭제할 레코드를 선택해 주세요!");
	history.back();
</script>
<%}%>	
