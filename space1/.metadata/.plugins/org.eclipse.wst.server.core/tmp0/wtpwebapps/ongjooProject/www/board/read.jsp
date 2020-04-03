<%@ page contentType="text/html; charset=EUC-KR"%>
<%@page import="www.BoardBean"%>
<%
	request.setCharacterEncoding("EUC-KR");
	String board = request.getParameter("board");
%>
<jsp:useBean id="bMgr" class="www.BoardMgr" />
<%
	  int num = Integer.parseInt(request.getParameter("num"));
	  String nowPage = request.getParameter("nowPage");
	  String keyField = request.getParameter("keyField");
	  String keyWord = request.getParameter("keyWord");
	  bMgr.upCount(board, num);//��ȸ�� ����
	  BoardBean bBean = bMgr.getBoard(board, num);//�Խù� ��������
	  String name = bBean.getName();
	  String subject = bBean.getSubject();
      String regdate = bBean.getRegdate();
	  String content = bBean.getContent();
	  String filename = bBean.getFilename();
	  int filesize = bBean.getFilesize();
	  String ip = bBean.getIp();
	  int count = bBean.getCount();
	  session.setAttribute("bBean", bBean);//�Խù��� ���ǿ� ����
%>
<html>
<head>
<title>JSPBoard</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	function list(){
		<%if(board.equals("tblBoard")){%>
	 	document.listFrm.action="list.jsp";
	 	<%}else{%>
	 	document.listFrm.action="list2.jsp";
	 	<%}%>
	    document.listFrm.submit();
	 } 
	
	function down(filename){
		 document.downFrm.filename.value=filename;
		 document.downFrm.submit();
	}
</script>
</head>
<body bgcolor="#f9f1e5">
<br><br>
<table align="center" width="70%" border=0 cellspacing="3" cellpadding="0">
 <tr>
  <td bgcolor="#9CA2EE" height="25" align="center">���б�</td>
 </tr>
 <tr>
  <td colspan="2">
   <table border="0" cellpadding="3" cellspacing="0" width=100%> 
    <tr> 
  <td align="center" bgcolor="#DDDDDD" width="10%"> �� �� </td>
  <td bgcolor="#F0E6D7"><%=name%></td>
  <td align="center" bgcolor="#DDDDDD" width=10%> ��ϳ�¥ </td>
  <td bgcolor="#F0E6D7"><%=regdate%></td>
 </tr>
 <tr> 
    <td align="center" bgcolor="#DDDDDD"> �� ��</td>
    <td bgcolor="#F0E6D7" colspan="3"><%=subject%></td>
   </tr>
   <tr> 
     <td align="center" bgcolor="#DDDDDD">÷������</td>
     <td bgcolor="#F0E6D7" colspan="3">
     <% if( filename !=null && !filename.equals("")) {%>
  		<a href="javascript:down('<%=filename%>')"><%=filename%></a>
  		 &nbsp;&nbsp;<font color="blue">(<%=filesize%>KBytes)</font>  
  		 <%} else{%> ��ϵ� ������ �����ϴ�.<%}%>
     </td>
   </tr>
   <tr> 
    <td colspan="4"><br><pre><%=content%></pre><br></td>
   </tr>
   <tr>
    <td colspan="4" align="right">
     <%=ip%>�� ���� ���� ����̽��ϴ�./  ��ȸ��  <%=count%>
    </td>
   </tr>
   </table>
  </td>
 </tr>
 <tr>
  <td align="center" colspan="2"> 
 <hr size="1">
 [ <a href="javascript:list()" >����Ʈ</a> | 
 <a href="update.jsp?nowPage=<%=nowPage%>&num=<%=num%>&board=<%=board%>" >�� ��</a> |
 <a href="reply.jsp?nowPage=<%=nowPage%>&board=<%=board%>" >�� ��</a> |
 <a href="delete.jsp?nowPage=<%=nowPage%>&num=<%=num%>&board=<%=board%>">�� ��</a> ]<br>
  </td>
 </tr>
</table>

<form name="downFrm" action="download.jsp" method="post">
	<input type="hidden" name="filename">
</form>

<form name="listFrm" method="post">
	<input type="hidden" name="num" value="<%=num%>">
	<input type="hidden" name="nowPage" value="<%=nowPage%>">
	<%if(!(keyWord==null || keyWord.equals("null"))){ %>
	<input type="hidden" name="keyField" value="<%=keyField%>">
	<input type="hidden" name="keyWord" value="<%=keyWord%>">
	<%}%>
</form>
</body>
</html>