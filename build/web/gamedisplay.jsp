<%-- 
    Document   : gamedisplay.jsp
    Created on : Aug 6, 2015, 12:40:24 AM
    Author     : jyothsna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Set Game Display</title>
        <link rel="stylesheet" href="css/jquery.mobile-1.4.5.css">
        <link rel="stylesheet" href="css/gamelist.css">
        <script src="js/jquery-2.1.4.min.js"></script>
        <script src="js/handlebars-v3.0.3.js"></script>
        <script src="js/jquery.mobile-1.4.5.js"></script>
        <script src="js/gamedata.js"></script>
    </head>
    <body>
        <%
            String gameid = (String)request.getAttribute("gameid");
        %>
        <div id="gametitle">
            <label style="float: left"><b>Game Id: </b></label>
                <label id="gid"><b><%= gameid %></b></label>
        </div>
        <div id="gametablediv">
            <table id="gamecards" border="1" cellspacing="1" width="400" height="400">
                <!-- Generated by Java Script -->
            </table>
        </div>    
        <div id="gameplayerdiv">
            <table id="gameplayers" border="1" cellspacing="1" width="200" height="400">
                <!-- Generated by Java Script -->
            </table>

        </div>
        <div>
            <button id="mybutton" onclick="Return()">Return</button>
            <label><a href="javascript:history.back()">Go Back</a></label>
        </div>
    </body>
</html>