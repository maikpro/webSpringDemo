//Simple (or Streaming) Text Orientated Messaging Protocol.
var stompClient = null;
connect(); //beim Aufruf der Seite mit WebSocket verbinden!


function connect(){
    console.log("connect clicked!")
    var socket = new SockJS('/ws'); // In Klasse WebSocketConfig in Methode registerStompEndpoints registriert als Endpunkt
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame){
        console.log("Connected: " + frame);
        
        console.log("--> URL: " + socket._transport.url);
        var url = socket._transport.url;
        
        //url: ws://localhost:8080/ws/755/b40ckrv3/websocket
        //Aus URL soll sessionId gezogen werden:
        url = url.replace("ws://localhost:8080/ws/", "");
        url = url.replace("/websocket", "");
        url = url.replace(/^[0-9]+\//, "");
        console.log("session-id: " + url);
        const sessionId = url;

        //stompClient.subscribe( "/user/" + sessionId + "/queue/messages", function(message){
        stompClient.subscribe( "/user/chat/messages", function(message){
            console.log("subbbbbb!")
            //showGreeting( JSON.parse(greeting.body).content );
            console.log( message );
            showMessageInChat( message.body );
        });
        
    });
}

function sendMessage(){
    stompClient.send( "/app/chat", {}, JSON.stringify( {'inhalt': $("#inhalt").val()} ) );
}

function showMessageInChat(message){
    console.log(message);
    $("#chat").append("<tr><td>" + message + "</td></tr>");
}

$(function(){
    $("form").on("submit", function(e){
        e.preventDefault();
    });

    /*$("#connect").click( function(){
        connect();
    });*/

    $("#send").click(function(){
        sendMessage();
    });
});