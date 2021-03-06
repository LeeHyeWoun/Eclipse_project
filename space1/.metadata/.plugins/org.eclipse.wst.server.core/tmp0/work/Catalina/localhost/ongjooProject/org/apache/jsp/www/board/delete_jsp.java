/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.39
 * Generated at: 2019-06-11 12:22:34 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.www.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import www.BoardBean;

public final class delete_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("www.BoardBean");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=EUC-KR");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");

	 request.setCharacterEncoding("EUC-KR");
	String board = request.getParameter("board");

      out.write('\r');
      out.write('\n');
      www.BoardMgr bMgr = null;
      bMgr = (www.BoardMgr) _jspx_page_context.getAttribute("bMgr", javax.servlet.jsp.PageContext.PAGE_SCOPE);
      if (bMgr == null){
        bMgr = new www.BoardMgr();
        _jspx_page_context.setAttribute("bMgr", bMgr, javax.servlet.jsp.PageContext.PAGE_SCOPE);
      }
      out.write('\r');
      out.write('\n');

	  String nowPage = request.getParameter("nowPage");
	  int num = Integer.parseInt(request.getParameter("num"));
	  if(request.getParameter("pass")!=null){
			//비번을 입력을 해서 세션에 있는 pass 비교요청
	    String inPass = request.getParameter("pass");
		BoardBean bBean = (BoardBean)session.getAttribute("bBean");
		String dbPass = bBean.getPass();
		if(inPass.equals(dbPass)){
			bMgr.deleteBoard(board,num);
			String url = "list.jsp?nowPage="+nowPage;
			response.sendRedirect(url);
		}else{

      out.write("\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\talert(\"입력하신 비밀번호가 아닙니다.\");\r\n");
      out.write("\t\t\thistory.back();\r\n");
      out.write("\t\t</script>\r\n");
}
	}else{	

      out.write("\r\n");
      out.write("<title>JSP Board</title>\r\n");
      out.write("<link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tfunction check() {\r\n");
      out.write("\t  if (document.delFrm.pass.value == \"\") {\r\n");
      out.write("\t  alert(\"패스워드를 입력하세요.\");\r\n");
      out.write("\t  document.delFrm.pass.focus();\r\n");
      out.write("\t  return false;\r\n");
      out.write("\t  }\r\n");
      out.write("\t  document.delFrm.submit();\r\n");
      out.write("   }\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body bgcolor=\"#f9f1e5\">\r\n");
      out.write("<div align=\"center\">\r\n");
      out.write("<br><br>\r\n");
      out.write("<table width=\"50%\" cellspacing=\"0\" cellpadding=\"3\">\r\n");
      out.write(" <tr>\r\n");
      out.write("  <td bgcolor=#dddddd height=\"21\" align=\"center\">\r\n");
      out.write("      사용자의 비밀번호를 입력해 주세요.</td>\r\n");
      out.write(" </tr>\r\n");
      out.write("</table>\r\n");
      out.write("<form name=\"delFrm\" method=\"post\" action=\"delete.jsp?board=");
      out.print(board);
      out.write("\" >\r\n");
      out.write("<table width=\"70%\" cellspacing=\"0\" cellpadding=\"2\">\r\n");
      out.write(" <tr>\r\n");
      out.write("  <td align=\"center\">\r\n");
      out.write("   <table align=\"center\" border=\"0\" width=91%>\r\n");
      out.write("    <tr> \r\n");
      out.write("     <td align=\"center\">  \r\n");
      out.write("   \t   <input type=\"password\" name=\"pass\" size=\"17\" maxlength=\"15\">\r\n");
      out.write("  \t </td> \r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("     <td><hr size=\"1\" color=\"#eeeeee\"></td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("     <td align=\"center\">\r\n");
      out.write("   \t\t<input type=\"button\" value=\"삭제완료\" onClick=\"check()\"> \r\n");
      out.write("      \t<input type=\"reset\" value=\"다시쓰기\"> \r\n");
      out.write("      \t<input type=\"button\" value=\"뒤로\" onClick=\"history.go(-1)\">\r\n");
      out.write("  \t  </td>\r\n");
      out.write("    </tr> \r\n");
      out.write("   </table>\r\n");
      out.write("  </td>\r\n");
      out.write(" </tr>\r\n");
      out.write("</table>\r\n");
      out.write(" <input type=hidden name=\"nowPage\" value=\"");
      out.print(nowPage);
      out.write("\">\r\n");
      out.write(" <input type=hidden name=\"num\" value=\"");
      out.print(num);
      out.write("\">\r\n");
      out.write("</form> \r\n");
      out.write("</div>\r\n");
} 
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
