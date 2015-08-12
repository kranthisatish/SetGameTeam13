

$.mobile.document
	.on( "click", ".mybutton", function( event ) {
           alert("GMAE LOAD");
            
         });
var gid;

window.onload = function() {
    //clicked
};

var refreshIntervalId = setInterval(clicked, 5000);

function clicked() {
    var gid_label = document.getElementById("gid");
    gid = (gid_label.innerText || gid_label.textContent);    
    $.ajax({
        type: "POST",
        url: "GameImageDataServlet",
        contentType: "application/json",
        dataType: 'json',
        data:JSON.stringify({
            gameid: gid
        }),
        success: function(data) {
            var imageArray = [];
            $.each(data, function (index, gamedata) {     
               $.each(gamedata.faceImages, function(i, image) {
                  var img = document.createElement('img');
                  img.src = "data:image/gif;base64," + image;
                  imageArray.push(img); 
               });
               
            });
            updateTable(imageArray);
        },
        error: function() {
            //alert('Unable to get data');
        }
    });
    
    $.ajax({
        type: "POST",
        url: "GamePlayerDataServlet",
        contentType: "application/json",
        dataType: 'json',
        data:JSON.stringify({
            gameid: gid
        }),
        success: function(data) {
            var playerInfo = {};
            $.each(data, function (index, player) {     
                playerInfo[player.playerId] = player.no_of_sets;
            });
            
            updatePlayer(playerInfo);
            //updatePlayer(playerInfo);
        },
        error: function() {
            alert('Unable to get data');
        }
    });

}

function updateTable(imageArray) {
    
    $("#gamecards tr").remove();
    var len = imageArray.length;
    var no_rows = len / 3;
    
    var col = 0;
    for (var i = 0; i < no_rows; i++) {
        var img1 = imageArray[col++];
        var img2 = imageArray[col++];
        var img3 = imageArray[col++];
        var td1 = $("<td/>").append(img1);
        var td2 = $("<td/>").append(img2);
        var td3 = $("<td/>").append(img3);

        $("#gamecards")
            .append($('<tr>')
            .append(td1).append(td2).append(td3)    
            );
    }
}

function updatePlayer(playerInfo) {
    $("#gameplayers tr").remove();

    var keys = Object.keys(playerInfo);
    
    for (var i = 0; i < keys.length; i++) {
        var p = keys[i] + " (" + playerInfo[keys[i]] + ")";
        var td = $("<td/>").append(p);
        
        $("#gameplayers")
                .append($('<tr>')
                .append(td)
                );
    }
    
}

function Return() {
    clearInterval(refreshIntervalId );
    alert("CLEARED");
    history.back();
}

$(document).load(function() {
    alert("FUNCTION");

 });
 
 function updateview() {
    var body = document.getElementsByTagName("body")[0];
    var tbl     = document.createElement("table");
    
}



