<%@ page contentType="text/html; charset=EUC-KR"%>
<%request.setCharacterEncoding("EUC-KR");%>

<%
    session.invalidate();
	String ID = request.getParameter("id");
	
	if(ID==null){
%>
<script>
   alert('로그아웃 되었습니다.');
</script>
<%}%>
<script>
   top.document.location.reload(); 
   location.href="<%=request.getContextPath()%>/www/left.jsp";
</script>