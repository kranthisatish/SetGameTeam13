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
        <link rel="stylesheet" href="jquery.mobile-1.4.5.css">
        <script src="jquery-2.1.4.min.js"></script>
        <script src="jquery.mobile-1.4.5.js"></script>
    </head>
    <body>
        <div role="main" class="ui-content">
            <form id="gameListForm" method="POST" action="DisplayGameServlet">
            <ul data-role="listview" data-inset="true">                
                <%
                    ArrayList<Game> games = (ArrayList<Game>)request.getAttribute("gamelist");
                    for ( Game g : games) {
                %>
                <li data-id=<%=g.getGameId()%>><!--a href="www.google.com"-->
                    <%=g.getGameId()%><br>
                    <%=  g.getGameDesc() %><br>
                    <%=  "Max:" + g.getGameMaxPlayers() %><br>
                    <%=  "Time:" + g.getGameMaxTime() %><br>
                <!--/a-->
                </li>                  
                <% } %>
            </ul>
            </form>
        </div>
     </body>
</html>
