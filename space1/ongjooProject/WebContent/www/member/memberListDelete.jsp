<%@ page contentType="text/html;charset=EUC-KR" %>
<%@page import="www.MemberBean, java.util.*"%>

<%
	request.setCharacterEncoding("EUC-KR");
%>
<jsp:useBean id="mMgr" class="www.MemberMgr" />
<%
	String id = (String) session.getAttribute("idKey");
	MemberBean mBean = mMgr.getMember(id);
	
	int totalRecord=0;		//전체 레코드의 수
	int numPerPage=10;		//페이지당 레코드의 수
	int pagePerBlock=15;	//블럭당 페이지의 수
	
	int totalPage=0;		//전체 페이지 수
	int totalBlock=0;		//전체블럭 수
	
	int nowPage=1;			//현재 페이지
	int nowBlock=1;			//현재 블럭
	
	int start=0; 			//디비의 select 시작번호
	int end=10; 			//시작번호로 부터 가져올 select 갯수

	int listSize=0;			//현재 읽어온 회원의 수
	
	String keyWord = "", keyField = "";
	Vector<MemberBean> vlist = null;
	if (request.getParameter("keyWord") != null) {
		keyWord = request.getParameter("keyWord");
		keyField = request.getParameter("keyField");
	}
	if (request.getParameter("reload") != null){
		if(request.getParameter("reload").equals("true")) {
			keyWord = "";
			keyField = "";
		}
	}

	if (request.getParameter("nowPage") != null) {
		nowPage = Integer.parseInt(request.getParameter("nowPage"));
	}
	 start=(nowPage * numPerPage)-numPerPage;
	 end= start+numPerPage;
	 
	totalRecord = mMgr.getTotalCount(keyField, keyWord);
	totalPage =(int)Math.ceil((double)totalRecord / numPerPage);  //전체페이지수
	nowBlock= (int)Math.ceil((double)nowPage/pagePerBlock); //현재블럭 계산
	  
	totalBlock =(int)Math.ceil((double)totalPage / pagePerBlock);  //전체블럭계산

%>
<html>
<head>
<title>회원목록보기</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	function back() {
		history.back();
	}
	
	function pageing(page) {
		document.readFrm.nowPage.value = page;
		document.readFrm.submit();
	}
	
	function block(value){
		 document.readFrm.nowPage.value=<%=pagePerBlock%>*(value-1)+1;
		 document.readFrm.submit();
	} 
		
</script>
</head>
<body bgcolor="#f9f1e5" onLoad="regFrm.id.focus()">
	<div align="center">
		<br /><br />
	<table align="center" border="0" width="90%">
		<tr>
			<td align="center"><font color=red><b><h2>회원 삭제</h2></b></font></td>
		</tr>
		<tr>
			<td>Total : <%=totalRecord%>Articles(<font color="red">
			<%=nowPage%>/<%=totalPage%>Pages</font>)</td>
		</tr>
	</table>
	<form name="dForm" method="post" action="delete.jsp">
	<table align="center" border="0" width="90%" cellspacing="0" cellpadding="3">
		<tr>
			<td align="center" colspan="2">
				<%
					  vlist = mMgr.getMemberList(keyField, keyWord, start, end);
					  listSize = vlist.size();//브라우저 화면에 보여질 게시물갯수
					  if (vlist.isEmpty()) {
						out.println("등록된 게시물이 없습니다.");
					  } else {
				%>
				<table border="1" width="1200" cellspacing="0" cellpadding="2" align="center">
					<tr align="center" bgcolor="#996600">
						<td align="center">선택</td>
						<td align="center">아이디</td>
						<td align="center">패스워드</td>
						<td align="center">이름</td>
						<td align="center">성별</td>
						<td align="center">생년월일</td>
						<td align="center">이메일</td>
						<td align="center">우편번호</td>
						<td align="center">주소</td>
						<td align="center">취미</td>
						<td align="center">직업</td>
					</tr>
					<%
						for (int i=0; i<numPerPage; i++){
							if(i==listSize) break;
							MemberBean mB = vlist.get(i);
							String mId = mB.getId();
							String mPw = mB.getPwd();
							String mName = mB.getName();
							String mGender = mB.getGender();
							String mBirthday = mB.getBirthday();
							String mEmail = mB.getEmail();
							String mZipcode = mB.getZipcode();
							String mAddress = mB.getAddress();
							String[] mHobby = mB.getHobby();
							String mJob = mB.getJob();
					%>
					<tr>
						<td width="3%" align="center" >
							<input type="checkbox" name="delete" value="<%=mId%>">
						</td>
						<td width="6%"><%=mId%></td>
						<td width="6%"><%=mPw%></td>
						<td width="6%"><%=mName%></td>
						<td width="3%" align="center"><%=mGender%></td>
						<td width="6%"><%=mBirthday%></td>
						<td width="12%"><%=mEmail%></td>
						<td width="6%"><%=mZipcode%></td>
						<td width="*"><%=mAddress%></td>
						<td width="18%">
						<%
							String list[] = { "인터넷", "여행", "게임", "영화", "운동" };
							boolean more = false;
							for (int j = 0; j < list.length; j++) {
								if (mHobby[j].equals("1")){
									if (more == true){
										out.println(", ");
									}
									out.println( list[j]);
									if (more == false){
										more = true;
									}
								}
							}
						%>
						</td>
						<td width="12%"><%=mJob%></td>
					</tr>
					<%} //for%>
				</table>
				</form>
				<%} //if%>
  			</td>
 		</tr>
		<tr>
			<td colspan="2"><br /><br /></td>
		</tr>
		<tr>
			<td>
			<!-- 페이징 및 블럭 처리 Start--> 
			<%
   				  int pageStart = (nowBlock -1)*pagePerBlock + 1 ; //하단 페이지 시작번호
   				  int pageEnd = ((pageStart + pagePerBlock ) < totalPage) ?  (pageStart + pagePerBlock): totalPage+1; 
   				  //하단 페이지 끝번호
   				  if(totalPage !=0){
    			  	if (nowBlock > 1) {%>
    			  		<a href="javascript:block('<%=nowBlock-1%>')">prev...</a><%}%>&nbsp; 
    			  		<%for ( ; pageStart < pageEnd; pageStart++){%>
     			     	<a href="javascript:pageing('<%=pageStart %>')"> 
     					<%if(pageStart==nowPage) {%><font color="blue"> <%}%>
     					[<%=pageStart %>] 
     					<%if(pageStart==nowPage) {%></font> <%}%></a> 
    					<%}//for%>&nbsp; 
    					<%if (totalBlock > nowBlock ) {%>
    					<a href="javascript:block('<%=nowBlock+1%>')">.....next</a>
    				<%}%>&nbsp;  
   				<%}%>
 				<!-- 페이징 및 블럭 처리 End-->
			</td>
			<td align="right">
				<a href="javascript:back()">[회원목록]</a>
				&nbsp
				<input type="submit" value="[삭제]">
			</td>
		</tr>
	</table>
	</form>
	</div>
</body>
</html>
