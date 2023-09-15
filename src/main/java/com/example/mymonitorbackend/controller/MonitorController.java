package com.example.mymonitorbackend.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.mymonitorbackend.handler.ResourcesWebSocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class MonitorController {

    public String res;

    @Autowired
    private ResourcesWebSocketHandler webSocketHandler;

    @GetMapping("/ResourcesRequest")
    public ResponseEntity<String> requestDataFromDevice() throws IOException {
        try {
            webSocketHandler.sendRequestToFetchData();
            return ResponseEntity.ok("Data request sent to device.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Device not connected.");
        }
    }

}
