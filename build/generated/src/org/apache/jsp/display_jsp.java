package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import setgame.*;

public final class display_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!--%@ taglib uri=\"http://java.sun.com/jsp/jstl/core\" prefix=\"c\" %-->\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/jquery.mobile-1.4.5.css\">\n");
      out.write("        <script src=\"js/jquery-2.1.4.min.js\"></script>\n");
      out.write("        <script src=\"js/handlebars-v3.0.3.js\"></script>\n");
      out.write("        <script src=\"js/jquery.mobile-1.4.5.js\"></script>\n");
      out.write("        <script src=\"js/gamelist.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    <form action=\"DisplayGameServlet\" method=\"POST\" id=\"gamelistform\">\n");
      out.write("      <div data-role=\"page\" id=\"myPage\" style=\"max-height:640px; min-height:640px;\">\n");
      out.write("        <div id=\"main\" role=\"main\" class=\"ui-content\">\n");
      out.write("            <ul class=\"game-list\" data-role=\"listview\" data-inset=\"true\">                \n");
      out.write("                ");

                    ArrayList<Game> games = (ArrayList<Game>)request.getAttribute("gamelist");
                    for(Game g : games) {
                
      out.write("\n");
      out.write("                <li data-id=");
      out.print(g.getGameId());
      out.write("><a href=\"#\" data-id=");
      out.print(g.getGameId());
      out.write(" >\n");
      out.write("                    ");
      out.print(g.getGameId());
      out.write("<br>\n");
      out.write("                    ");
      out.print(  g.getGameDesc() );
      out.write("<br>\n");
      out.write("                    ");
      out.print(  "Max:" + g.getGameMaxPlayers() );
      out.write("<br>\n");
      out.write("                    ");
      out.print(  "Time:" + g.getGameMaxTime() );
      out.write("<br>\n");
      out.write("                </a>\n");
      out.write("                </li>                  \n");
      out.write("                ");
 } 
      out.write("\n");
      out.write("            </ul>\n");
      out.write("            <!--/form-->\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("            <input type=\"hidden\" id=\"gameid\" name=\"gameid\" value=\"\">\n");
      out.write("    </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
