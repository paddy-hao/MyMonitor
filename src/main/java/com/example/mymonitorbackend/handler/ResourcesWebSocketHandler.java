package com.example.mymonitorbackend.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

@Component
public class ResourcesWebSocketHandler extends TextWebSocketHandler {

    private WebSocketSession session;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        this.session = session;
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) {
        // Handle data received from Android device
        System.out.println("Received data from device: " + message.getPayload());
    }

    public void sendRequestToFetchData() throws  IOException {
        if (session != null && session.isOpen()) {
            System.out.println("send successful");
            session.sendMessage(new TextMessage("REQUEST_DATA"));
        } else {
            System.out.println("send failure");
        }
    }
}