# spring-thymeleaf-example

## Preface
This project contains a simple example with Spring Boot and WebSocket.

## Getting Started

You need clone the repository https://github.com/facu0202/spring-websocket-stomp.git. If you use eclipse, you can import proyect using "import-> Existing Maven Project". 

For run application, you run de application with maven command "mvn spring-boot:run". If you use eclipse create a Maven Build and add "spring-boot:run" as Goals.

## How to uses it

This url has magic http://localhost:8080/

You have two buttons "Send Message by REST" and "Send Message by Socket", you can send a message and the back end take a message a put in the socket.

## Details

The application was built using "spring initializr" with the params:
- Web, WebSocket, Actuator, DevTools, Thymeleaf.

The application has a WebSocketConfig, in this class has a broker configuration. 

The application has two controllers, MessageBroker and AppController. 
MessageBroker has a subscribe mapping (listening to the channel) and send a message to channel. 
AppController has a REST method a invoke MessageBroker to send a message to socket.

If you have any cuestion send and email facundoferro@gmail.com



