package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class gamedisplay_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Set Game Display</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/jquery.mobile-1.4.5.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/gamelist.css\">\n");
      out.write("        <script src=\"js/jquery-2.1.4.min.js\"></script>\n");
      out.write("        <script src=\"js/handlebars-v3.0.3.js\"></script>\n");
      out.write("        <script src=\"js/jquery.mobile-1.4.5.js\"></script>\n");
      out.write("        <script src=\"js/gamedata.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            String gameid = (String)request.getAttribute("gameid");
        
      out.write("\n");
      out.write("        <div id=\"gametitle\">\n");
      out.write("            <label style=\"float: left\"><b>Game Id: </b></label>\n");
      out.write("                <label id=\"gid\"><b>");
      out.print( gameid );
      out.write("</b></label>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"gametablediv\">\n");
      out.write("            <table id=\"gamecards\" border=\"1\" cellspacing=\"1\" width=\"400\" height=\"400\">\n");
      out.write("                <!-- Generated by Java Script -->\n");
      out.write("            </table>\n");
      out.write("        </div>    \n");
      out.write("        <div id=\"gameplayerdiv\">\n");
      out.write("            <table id=\"gameplayers\" border=\"1\" cellspacing=\"1\" width=\"200\" height=\"400\">\n");
      out.write("                <!-- Generated by Java Script -->\n");
      out.write("            </table>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <div>\n");
      out.write("            <button id=\"mybutton\" onclick=\"Return()\">Return</button>\n");
      out.write("            <label><a href=\"javascript:history.back()\">Go Back</a></label>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
