<%@ page contentType="text/html; charset=EUC-KR"%>
<%
	request.setCharacterEncoding("EUC-KR");
	String board = request.getParameter("board");
%>
<jsp:useBean id="bMgr" class="www.BoardMgr"/>
<jsp:useBean id="reBean" class="www.BoardBean"/>
<jsp:setProperty property="*" name="reBean"/>
<%
	bMgr.replyUpBoard(board,reBean.getRef(), reBean.getPos());
	bMgr.replyBoard(board,reBean);
	String nowPage = request.getParameter("nowPage");
	if(board.equals("tblBoard")){
		response.sendRedirect("list.jsp?nowPage="+nowPage);
	}else{
		response.sendRedirect("list2.jsp?nowPage="+nowPage);
	}
%>