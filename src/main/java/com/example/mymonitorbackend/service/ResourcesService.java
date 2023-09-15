package com.example.mymonitorbackend.service;

import com.alibaba.fastjson.JSONObject;
import com.example.mymonitorbackend.domain.Resources;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author bohao
* @description Database operation service for table [Resources].
*/
public interface ResourcesService extends IService<Resources> {

    void saveData(JSONObject jsonData);
}
