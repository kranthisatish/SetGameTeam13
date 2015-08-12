package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>JSP Page</title>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            function validate() {\n");
      out.write("                var id =  document.getElementById(\"game_id\");\n");
      out.write("                var desc = document.getElementById(\"game_desc\");\n");
      out.write("                var maxPlayers = document.getElementById(\"game_max_players\");\n");
      out.write("                var maxTime = document.getElementById(\"game_time_limit\");\n");
      out.write("                \n");
      out.write("                var valid = true;\n");
      out.write("                if (id.value.length <= 0 ||  desc.value.length <=0) {\n");
      out.write("                    alert(\"Enter ID and Description\");\n");
      out.write("                    valid = false;\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                if ((maxPlayers.value.length > 0 && isNaN(maxPlayers.value)) ||\n");
      out.write("                        maxTime.value.length > 0 && isNaN(maxTime.value))  {\n");
      out.write("                    alert(\"Enter Valid input\");\n");
      out.write("                    valid = false;\n");
      out.write("                } \n");
      out.write("                \n");
      out.write("                \n");
      out.write("                //alert(\"Enter ID and Description\");\n");
      out.write("                return valid;\n");
      out.write("            };\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1> Set Game </h1>\n");
      out.write("        <form name=\"Name Input Form\" action=\"CreateGameServlet\" onsubmit=\"return validate()\">\n");
      out.write("            <label>Game ID: </label>\n");
      out.write("            <input type=\"text\" id=\"game_id\" name=\"game_id\" value=\"\" /><br>\n");
      out.write("            <label>Description: </label><br>\n");
      out.write("            <textarea id=\"game_desc\" name=\"game_desc\" rows=\"10\" columns=\"10\"></textarea><br><br>\n");
      out.write("            <label>Max Players: </label>\n");
      out.write("            <input type=\"text\" id=\"game_max_players\" name=\"game_max_players\" value=\"10\"/><br>\n");
      out.write("            <label>Timed Limit: </label>\n");
      out.write("            <input type=\"text\" id=\"game_time_limit\" name=\"game_time_limit\" value=\"60\"/><br><br><br>\n");
      out.write("            <input type=\"submit\" value=\"Create\" name=\"create_btn\" />\n");
      out.write("        </form>\n");
      out.write("        <form name=\"Display Games\" action=\"DisplayAllGamesServlet\">\n");
      out.write("            <input type=\"submit\" value=\"Display Games\" name=\"display_btn\">\n");
      out.write("        </form>\n");
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
