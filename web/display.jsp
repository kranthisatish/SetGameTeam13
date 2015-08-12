<%-- 
    Document   : display
    Created on : Aug 4, 2015, 8:45:20 PM
    Author     : jyothsna
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<%@ page import="java.util.*" %>
<%@ page import="setgame.*" %>
<!--%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %-->

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/jquery.mobile-1.4.5.css">
        <script src="js/jquery-2.1.4.min.js"></script>
        <script src="js/handlebars-v3.0.3.js"></script>
        <script src="js/jquery.mobile-1.4.5.js"></script>
        <script src="js/gamelist.js"></script>
    </head>
    <body>
    <form action="DisplayGameServlet" method="POST" id="gamelistform">
      <div data-role="page" id="myPage" style="max-height:640px; min-height:640px;">
        <div id="main" role="main" class="ui-content">
            <ul class="game-list" data-role="listview" data-inset="true">                
                <%
                    ArrayList<Game> games = (ArrayList<Game>)request.getAttribute("gamelist");
                    for(Game g : games) {
                %>
                <li data-id=<%=g.getGameId()%>><a href="#" data-id=<%=g.getGameId()%> >
                    <%=g.getGameId()%><br>
                    <%=  g.getGameDesc() %><br>
                    <%=  "Max:" + g.getGameMaxPlayers() %><br>
                    <%=  "Time:" + g.getGameMaxTime() %><br>
                </a>
                </li>                  
                <% } %>
            </ul>
            <!--/form-->
        </div>
      </div>
            <input type="hidden" id="gameid" name="gameid" value="">
    </form>
    </body>
</html>
