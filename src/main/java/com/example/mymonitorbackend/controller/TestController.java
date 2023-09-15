package com.example.mymonitorbackend.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.mymonitorbackend.service.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class TestController {
    public String res;

    @Autowired
    private ResourcesService resourcesService;

    @GetMapping("/test")
    private String test(){
        return res;
    }

    @PostMapping("/monitor_data")
    public String receiveMonitorData(@RequestBody JSONObject jsonData) {
        try {
            res = jsonData.toString();
            System.out.println(res);

            resourcesService.saveData(jsonData);

            return res;
        } catch (Exception e) {
            return "Error occurred while processing resource monitor data."+HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    @PostMapping("/monitor_data_ios")
    public String receiveMonitorDataFromIOS(@RequestBody JSONObject jsonData) {
        try {
            res = jsonData.toString();
            System.out.println(res);

            return res;
        } catch (Exception e) {
            return "Error occurred while processing resource monitor data."+HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }

}
