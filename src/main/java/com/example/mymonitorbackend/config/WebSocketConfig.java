package com.example.mymonitorbackend.config;

import com.example.mymonitorbackend.handler.ResourcesWebSocketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    // Register custom WebSocket handlers and set their mapping URLs.
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        // Registering a new handler for the "/monitor" endpoint and allowing all origins.
        registry.addHandler(resourcesWebSocketHandler(), "/monitor").setAllowedOrigins("*");
    }

    // This method returns a new instance of ResourcesWebSocketHandler.
    public ResourcesWebSocketHandler resourcesWebSocketHandler() {
        return new ResourcesWebSocketHandler();
    }
}

