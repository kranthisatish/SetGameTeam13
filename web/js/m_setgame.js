
var gameId;
var playerId;

var sel_cards_index = [];
var sel_cards_data = [];

$(document).on("pagecontainershow", function () {
    var activePage = $.mobile.pageContainer.pagecontainer("getActivePage");

    var activePageId = activePage[0].id;
    switch (activePageId) {
        case 'gamelistpage':
            //alert("Game list page");
            loadGameList();
            break;

        default:
    }
});

$.mobile.document.on( "click", ".game-list a", function( event ) {
    event.preventDefault();
    event.stopPropagation();
    var gid = $( event.target ).attr( "data-id" );
    //alert(gid);
    gameId = gid;
    loadGame(gid);
        
});

$.mobile.document.on( "click", ".card-list a", function( event ) {
    event.preventDefault();
    event.stopPropagation();
    var target = $( event.target );
    var parent = $( event.target ).parent();
    var cardid = target.attr( "card-id" ).replace("img-","");
    var id = target.attr( "id" ).replace("img-", "");
    
    index = $.inArray(id, sel_cards_index);
    len = sel_cards_index.length;

    alert(sel_cards_index + " index:" + index + " len:" + len);
    
    if ( index > -1) {
        //alert("ID: " + id + "already");
        parent.attr('class', 'ui-bar ui-bar-a');
        parent.attr('style', 'height:100px width=100px');
        //parent.removeClass('selected');
        //parent.addClass('selected');
        //$("#cardgrid").enhanceWithin();
        sel_cards_index.splice(index, 1);
        sel_cards_data.splice($.inArray(cardid, sel_cards_data), 1);
        //alert("After removal" + sel_cards_index);
  
    } else {
        //alert("ID: " + id + "new");
        if (len < 3) {
            parent.attr('class', 'ui-bar ui-bar-b');
            parent.attr('style', 'height:100px width=100px');
            //parent.removeClass('ui-bar ui-bar-a');
            //parent.addClass('ui-bar ui-bar-b');
            //parent.addClass('selected');
            //$("#cardgrid").enhanceWithin();
            sel_cards_index.splice(len,1,id);
            sel_cards_data.splice(len,1,cardid);
        }
    }
            
});

function submitSet() {
    alert ("Cards: " + sel_cards_index + " - " + sel_cards_data);
    if (sel_cards_index.length !== 3) {
        return;
    }
    var card1 = sel_cards_data[0];
    var card2 = sel_cards_data[1];
    var card3 = sel_cards_data[2];

    $.ajax({
        type: "POST",
        url: "SetServlet",
        contentType: "application/json",
        dataType: 'json',
        data:JSON.stringify({
            playerid: playerId,
            gameid: gameId,
            card1: card1,
            card2: card2,
            card3: card3
        }),
        
        success: function(data) {
            //alert(data);
            if ( data === "True" ) {
                alert("Set");
                fetchCards();
            } else {
                alert("Not a Set");
                clearCards();
            }
        },
        error: function() {
            alert("Server request failed. Try again later...");
        }
    });
    
}

function fetchCards() {
        $.ajax({
        type: "POST",
        url: "SendCardServlet",
        contentType: "application/json",
        dataType: 'json',
        data:JSON.stringify({
            playerid: playerId,
            gameid: gameId
        }),
        
        success: function(data) {
            var cardids = [];
            $.each(data, function (index, card) {
                var identifier = card.identifier;
                var number = card.number;
                var color = card.color;
                var shape = card.shape;
                var shade = card.shade;
                cardids.push(identifier);
            });
            
            replaceCards(cardids);
        },
        error: function() {
            alert("Server request failed. Try again later...");
        }
    });

}

function replaceCards(cardids) {
    var len = cardids.length;
    
    alert(cardids);
    
    for (var i = 0; i < 3; i++) {
        var id = sel_cards_index[i];
        var cardid = cardids[i];

        $('#'+'img-'+id).attr('src', 'images/' + cardid + ".gif");
        $('#'+'img-'+id).attr('card-id', 'img-' + cardid);
        $('#' + id).attr('card-id', cardid);
        $("#cardgrid").enhanceWithin();
    }
    clearCards();

}

function clearCards() {
    var len = sel_cards_index.length;
    
    for (var i = 0; i < len; i++) {
        var id = sel_cards_index[i];
        var parent = $('#' + id).parent();
        
        parent.attr('class', 'ui-bar ui-bar-a');
    }
    $("#cardgrid").enhanceWithin();
    sel_cards_index = [];
    sel_cards_data = [];
}

function loadGame(gid) {
    $.ajax({
        type: "POST",
        url: "GameServlet",
        contentType: "application/json",
        dataType: 'json',
        data:JSON.stringify({
            playerid: playerId,
            gameid: gid
        }),
        
        success: function(data) {
            //alert("SUCCESS");
            var cardids = [];
            $.mobile.changePage("#gamepage");
            $.each(data, function (index, card) {
                var identifier = card.identifier;
                var number = card.number;
                var color = card.color;
                var shape = card.shape;
                var shade = card.shade;
                cardids.push(identifier);
            });
            
            loadCards(cardids);
        },
        error: function() {
            alert("Server request failed. Try again later...");
        }
    });
}

function loadCards(cardids) {
    
    $("#cardgrid div").remove();
    var len = cardids.length;
    
    for (var i = 0, class_div = "a"; i < len ; i++) {
        var cardid = cardids[i];
        var template = $("#cardTemplate").html()
                .replace("{{uiClass}}", "ui-block-" + class_div)
                .replace("{{cardnum}}", cardid)
                .replace("{{id}}", i)
                .replace("{{cardnum}}", cardid)
                .replace("{{id}}", i)
                .replace("{{imgSrc}}", "images/" + cardid + ".gif");
        $("#cardgrid").append(template);
        switch(class_div) {
            case 'a': class_div = 'b'; break;
            case 'b': class_div = 'c'; break;
            case 'c': class_div = 'a'; break;
        }
    }
    $("#cardgrid").enhanceWithin();

}

function signUp() {
   //alert ("Signup called");
   $.mobile.changePage("#signuppage"); 
   signUpReset();
}

function signUpSubmit() {
    var suserid = $("#suserid").val();
    var spasswd = $("#spassword").val();
    var rpasswd = $("#rpassword").val();
    
    if ( suserid.length < 4 || spasswd.length < 4 ) {
        alert ("User ID/Password should have min 4 characters");
        return;
    }
    
    if (spasswd !== rpasswd) {
        alert ("Passwords do not match");
        return;
    }
    
    $.ajax({
        type: "POST",
        url: "SignUpServlet",
        contentType: "application/json",
        dataType: 'json',
        data:JSON.stringify({
            userid: suserid,
            passwd: spasswd
        }),
        
        success: function(data) {
            if ( data === 'Success') {
                alert("Sign Up Successful... Login to play game");
                $.mobile.changePage("#loginpage");
            } else {
                alert("Sign Up Failed");
            }
        },
        error: function() {
            alert("Server request failed. Try again later...");
            signUpReset();
        }
    });
}

function loginSubmit() {
    var userid = $("#userid").val();
    var passwd = $("#password").val();
    if ( userid.length < 4 || passwd.length < 4) {
        alert ("User ID/Password should have min 4 characters");
        return;
    }

    $.ajax({
        type: "POST",
        url: "LoginServlet",
        contentType: "application/json",
        dataType: 'json',
        data:JSON.stringify({
            userid: userid,
            passwd: passwd
        }),
        
        success: function(data) {
            //alert("SUCCESS");
            if ( data === 'Success') {
                //alert("Sign Up Successful... Login to play game");
                playerId = userid;
                $.mobile.changePage("#gamelistpage");
            } else {
                alert("Login Failed");
                loginReset();
            }

        },
        error: function() {
            alert("Server request failed. Try again later...");
            loginReset();
        }
    });
}

function loadGameList() {
    $("div#gamelist ul").remove();
    $.ajax({
        type: "POST",
        url: "GameListServlet",
        contentType: "application/json",
        dataType: 'json',
        data:JSON.stringify({
            playerid: playerId
        }),
        
        success: function(data) {
            //alert("Loaded Game List");

            $.each(data, function (index, game) {     
                var id = game.id;
                var desc = game.desc;
                var maxPlayers = game.maxPlayers;
                var maxTime = game.maxTime;

                var template = $("#gameListTemplate").html()
                        .replace("{{gameId}}", id)
                        .replace("{{gameId}}", id)
                        .replace("{{gameId}}", id)
                        .replace("{{gameDesc}}", desc)
                        .replace("{{maxPlayers}}", maxPlayers)
                        .replace("{{maxTime}}", maxTime);

                $("#gamelist").append(template);
                $("div#gamelist ul").listview();
            });
            

        },
        error: function() {
            alert("Server request failed. Try again later...");
        }
    });
}

function loginReset() {
    $("#userid").val('');
    $("#password").val('');
}

function signUpReset() {
    $("#suserid").val('');
    $("#spassword").val('');
    $("#rpassword").val('');
}

