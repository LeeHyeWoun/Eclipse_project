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
			message += "를 삭제했습니다.";
%>
<script>
	alert("<%=message%>");
	location.reload(); 
	location.href="<%=request.getContextPath()%>/www/member/memberList.jsp";
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
