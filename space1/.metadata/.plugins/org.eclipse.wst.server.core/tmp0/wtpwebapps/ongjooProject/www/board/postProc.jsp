<%@ page contentType="text/html; charset=EUC-KR"%>
<%
	request.setCharacterEncoding("EUC-KR");
	String board = request.getParameter("board");
%>
<jsp:useBean id="bMgr" class="www.BoardMgr"/>
<%
	bMgr.insertBoard(board,request);
	if(board.equals("tblBoard")){
		response.sendRedirect("list.jsp");
	}
	else{
		response.sendRedirect("list2.jsp");
	}
%>