<%@ page contentType="text/html;charset=EUC-KR" %>
<%@page import="www.MemberBean, java.util.*"%>

<%
	request.setCharacterEncoding("EUC-KR");
%>
<jsp:useBean id="mMgr" class="www.MemberMgr" />
<%
	String id = (String) session.getAttribute("idKey");
	MemberBean mBean = mMgr.getMember(id);
	
	int totalRecord=0;		//��ü ���ڵ��� ��
	int numPerPage=10;		//�������� ���ڵ��� ��
	int pagePerBlock=15;	//���� �������� ��
	
	int totalPage=0;		//��ü ������ ��
	int totalBlock=0;		//��ü�� ��
	
	int nowPage=1;			//���� ������
	int nowBlock=1;			//���� ��
	
	int start=0; 			//����� select ���۹�ȣ
	int end=10; 			//���۹�ȣ�� ���� ������ select ����

	int listSize=0;			//���� �о�� ȸ���� ��
	
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
	totalPage =(int)Math.ceil((double)totalRecord / numPerPage);  //��ü��������
	nowBlock= (int)Math.ceil((double)nowPage/pagePerBlock); //����� ���
	  
	totalBlock =(int)Math.ceil((double)totalPage / pagePerBlock);  //��ü�����

%>
<html>
<head>
<title>ȸ����Ϻ���</title>
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
			<td align="center"><font color=red><b><h2>ȸ�� ����</h2></b></font></td>
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
					  listSize = vlist.size();//������ ȭ�鿡 ������ �Խù�����
					  if (vlist.isEmpty()) {
						out.println("��ϵ� �Խù��� �����ϴ�.");
					  } else {
				%>
				<table border="1" width="1200" cellspacing="0" cellpadding="2" align="center">
					<tr align="center" bgcolor="#996600">
						<td align="center">����</td>
						<td align="center">���̵�</td>
						<td align="center">�н�����</td>
						<td align="center">�̸�</td>
						<td align="center">����</td>
						<td align="center">�������</td>
						<td align="center">�̸���</td>
						<td align="center">�����ȣ</td>
						<td align="center">�ּ�</td>
						<td align="center">���</td>
						<td align="center">����</td>
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
							String list[] = { "���ͳ�", "����", "����", "��ȭ", "�" };
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
			<!-- ����¡ �� �� ó�� Start--> 
			<%
   				  int pageStart = (nowBlock -1)*pagePerBlock + 1 ; //�ϴ� ������ ���۹�ȣ
   				  int pageEnd = ((pageStart + pagePerBlock ) < totalPage) ?  (pageStart + pagePerBlock): totalPage+1; 
   				  //�ϴ� ������ ����ȣ
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
 				<!-- ����¡ �� �� ó�� End-->
			</td>
			<td align="right">
				<a href="javascript:back()">[ȸ�����]</a>
				&nbsp
				<input type="submit" value="[����]">
			</td>
		</tr>
	</table>
	</form>
	</div>
</body>
</html>
