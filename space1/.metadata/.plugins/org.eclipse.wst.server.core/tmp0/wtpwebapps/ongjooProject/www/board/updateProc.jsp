<%@ page contentType="text/html; charset=EUC-KR"%>
<%request.setCharacterEncoding("EUC-KR");%>
<jsp:useBean id="bMgr" class="www.BoardMgr" />
<jsp:useBean id="bBean" class="www.BoardBean" scope="session"/>
<jsp:useBean id="upBean" class="www.BoardBean"/>
<jsp:setProperty property="*" name="upBean"/>
<%
	  String nowPage = request.getParameter("nowPage");
		String board = request.getParameter("board");
	  //bean에 있는 pass와 upBean pass를 비교(read.jsp)
	  String upPass = upBean.getPass();
	  String inPass = bBean.getPass();
	  if(upPass.equals(inPass)){
	    bMgr.updateBoard(board, upBean);
		String url = "read.jsp?nowPage="+nowPage+"&num="+upBean.getNum()+"&board="+board;
		response.sendRedirect(url);
	  }else{
%>
	<script type="text/javascript">
		alert("입력하신 비밀번호가 아닙니다.");
		history.back();
	</script>
<%}%>