var socket = new SockJS("/ws/");
var stompClient = Stomp.over(socket);

// Render data from server into HTML, registered as callback
// when subscribing to price topic
function renderMessage(frame) {
  var body = frame.body 
  $('#message').append(body  +"</BR>");
}

// Callback function to be called when stomp client is connected to server
var connectCallback = function() {
  stompClient.subscribe('/topic/WebSocketExample/message', renderMessage);
}; 

// Callback function to be called when stomp client could not connect to server
var errorCallback = function(error) {
  alert(error.headers.message);
};

// Connect to server via websocket
stompClient.connect("guest", "guest", connectCallback, errorCallback);

// Send by Socket
function sendSocket() {
	var text = $('.new .textMessageSocket').val();
	stompClient.send('/app/message', {}, JSON.stringify(text));
}
 
 // Send json by rest
function sendRest()
{
	 		var text = $('.new .textMessage').val();
	        $.ajax({
	            url: '/message?mode=1&channel='+getChanelName(),
	            type: 'POST',
	            dataType: 'json',
	            data: JSON.stringify( {"message":text }),
	            contentType: 'application/json; charset=utf-8',
	    });
}
 
