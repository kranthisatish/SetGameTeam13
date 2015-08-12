

$.mobile.document.on( "click", ".game-list a", function( event ) {
            var gid = $( event.target ).attr( "data-id" );

            var form = document.forms["gamelistform"];
            /*
            var hiddenField = document.createElement("input");
            hiddenField.setAttribute("type", "hidden");
            hiddenField.setAttribute("name", "gameid");
            hiddenField.setAttribute("id", "gameid");
            hiddenField.setAttribute("value", gid);
            */
           
            $("#gameid").val(gid);

            //form.appendChild(hiddenField);
            form.submit();
            
         });

            
            



/*
function submitform() {
    alert("GOOD");
    alert($( event.target ).attr( "data-id" ));
    //alert("GOOD");
};
*/



