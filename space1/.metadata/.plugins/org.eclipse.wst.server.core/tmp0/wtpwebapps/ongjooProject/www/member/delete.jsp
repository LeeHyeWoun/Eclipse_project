<%@ page contentType="text/html; charset=EUC-KR"%>
<%@page import="java.util.*"%>

<%request.setCharacterEncoding("EUC-KR");%>

<jsp:useBean id="mMgr" class="www.MemberMgr"/>

<%
	String[] IDs = request.getParameterValues("delete");
	
	String message = "";

	if(IDs!=null){
		boolean result = false;
		for(int j=0; j<IDs.length; j++){
			if(mMgr.deleteMember(IDs[j])){
				result = true;
			}
		}
		if(result){
			for(int i=0; i<IDs.length; i++){
				if(i!=0){
					message += ", ";
				}
				message += IDs[i];
			}
			message += "�� �����߽��ϴ�.";
%>
<script>
	alert("<%=message%>");
	location.reload(); 
	location.href="<%=request.getContextPath()%>/www/member/memberList.jsp";
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
