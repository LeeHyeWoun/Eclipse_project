<%@ page contentType="text/html; charset=EUC-KR" %>
<%request.setCharacterEncoding("EUC-KR");%>
<jsp:useBean id="mMgr" class="www.MemberMgr"/>
<jsp:useBean id="mBean" class="www.MemberBean"/>
<jsp:setProperty  name="mBean" property="*"/>
<%
	String id = (String) session.getAttribute("idKey");
	boolean result = mMgr.updateMember(mBean);
	if(result){
%>
<script type="text/javascript">
		alert("ȸ������ ���� �Ͽ����ϴ�.");
		<%if(id.equals(mBean.getId())){%>
		location.href="../main.jsp";
		<%}else{%>
		location.href="memberList.jsp";
		<%}%>
		
</script>
<% }else{%>
<script type="text/javascript">
		alert("ȸ������ ������ ���� �Ͽ����ϴ�.");
		history.back();
</script>
<%} %>