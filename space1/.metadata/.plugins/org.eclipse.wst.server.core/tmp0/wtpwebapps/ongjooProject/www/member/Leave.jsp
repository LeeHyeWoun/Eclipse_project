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
			message = "Ż�� ���������� ó���Ǿ����ϴ�.";
%>
<script>
	alert("<%=message%>");
	location.reload(); 
	location.href="logout.jsp?id=<%=ID%>";
</script>
<%		}else{%>
<script type="text/javascript">
		alert("ȸ��Ż�� �����Ͽ����ϴ�.");
		history.back();
</script>
<%		}} else{%>
<script>
	alert("������ ���ڵ带 ������ �ּ���!");
	history.back();
</script>
<%}%>	
