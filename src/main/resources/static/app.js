//Simple (or Streaming) Text Orientated Messaging Protocol.
var stompClient = null;

function connect(){
    var socket = new SockJS('/gs-guide-websocket'); // In Klasse WebSocketConfig in Methode registerStompEndpoints registriert als Endpunkt
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame){
        console.log("Connected: " + frame);
        
        stompClient.subscribe("/topic/greetings", function(greeting){
            console.log("subbbbbb!")
            showGreeting(JSON.parse(greeting.body).content);
        });

    });
}

function sendName(){
    stompClient.send( "/app/hello", {}, JSON.stringify( {'name': $("#name").val()} ) );
}

function showGreeting(message){
    console.log(message);
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

$(function(){
    $("form").on("submit", function(e){
        e.preventDefault();
    });

    $("#connect").click( function(){
        connect();
    });

    $("#send").click(function(){
        sendName();
    });
});