//Simple (or Streaming) Text Orientated Messaging Protocol.
var stompClient = null;
connect(); //beim Aufruf der Seite mit WebSocket verbinden!

//Erstelle ein WebSocket mit Protokoll STOMP (Simple (or Streaming) Text Orientated Messaging Protocol) für nachrichtenbasierte Kommunikation.
function connect(){
    console.log("connect clicked!")
    var socket = new SockJS('/ws'); // In Klasse WebSocketConfig in Methode registerStompEndpoints registriert als Endpunkt
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame){
        console.log("Connected: " + frame);
        stompClient.subscribe( "/user/chat/messages", function(message){
            console.log( message );
            showMessageInChat( message.body );
        });
    });
}

/*Der Client sendet die Nachricht an die URL /app/chat im Backend wird die Methode nachrichtSenden aufgerufen und sendet die Nachricht an den entsprechenden User weiter.*/
function sendMessage(){
    stompClient.send( "/app/chat", {}, JSON.stringify( {'inhalt': $("#inhalt").val()} ) );
    showOwnMessageInChat( $("#inhalt").val() + " " + new Date());
    clearInput();
}

/*Nachdem der Client eine */
function showMessageInChat(message){
    console.log(message);
    $("#chat").append("<tr style='text-align: right;'><td>" + message + "</td></tr>");
}

/*Nachdem der Client eine Nachricht versendet hat, wird seine eigene Nachricht im Chat angezeigt.*/
function showOwnMessageInChat(message){
    $("#chat").append("<tr><td>Du: " + message + "</td></tr>");
}

/*Nachdem der Client eine Nachricht versendet hat, wird die Nachricht im Input-Field gelöscht.*/
function clearInput(){
    $("#inhalt").val("");
}


$(function(){
    /*Nachdem der Client den Senden-Button tätigt, soll die Seite nicht neu geladen werden!*/
    $("form").on("submit", function(e){
        e.preventDefault();
    });

    /*Nachdem der Client den Senden-Button tätigt, soll die Nachricht gesendet werden.*/
    $("#send").click(function(){
        sendMessage();
    });
});