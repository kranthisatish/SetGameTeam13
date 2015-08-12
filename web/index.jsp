<%-- 
    Document   : index
    Created on : Aug 4, 2015, 2:31:54 PM
    Author     : jyothsna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript">
            function validate() {
                var id =  document.getElementById("game_id");
                var desc = document.getElementById("game_desc");
                var maxPlayers = document.getElementById("game_max_players");
                var maxTime = document.getElementById("game_time_limit");
                
                var valid = true;
                if (id.value.length <= 0 ||  desc.value.length <=0) {
                    alert("Enter ID and Description");
                    valid = false;
                }
                
                if ((maxPlayers.value.length > 0 && isNaN(maxPlayers.value)) ||
                        maxTime.value.length > 0 && isNaN(maxTime.value))  {
                    alert("Enter Valid input");
                    valid = false;
                } 
                
                
                //alert("Enter ID and Description");
                return valid;
            };
        </script>
    </head>
    <body>
        <h1> Set Game </h1>
        <form name="Name Input Form" action="CreateGameServlet" onsubmit="return validate()">
            <label>Game ID: </label>
            <input type="text" id="game_id" name="game_id" value="" /><br>
            <label>Description: </label><br>
            <textarea id="game_desc" name="game_desc" rows="10" columns="10"></textarea><br><br>
            <label>Max Players: </label>
            <input type="text" id="game_max_players" name="game_max_players" value="10"/><br>
            <label>Timed Limit: </label>
            <input type="text" id="game_time_limit" name="game_time_limit" value="60"/><br><br><br>
            <input type="submit" value="Create" name="create_btn" />
        </form>
        <form name="Display Games" action="DisplayAllGamesServlet">
            <input type="submit" value="Display Games" name="display_btn">
        </form>
    </body>
</html>
