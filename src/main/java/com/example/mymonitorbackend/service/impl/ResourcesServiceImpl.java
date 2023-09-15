package com.example.mymonitorbackend.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mymonitorbackend.domain.Resources;
import com.example.mymonitorbackend.service.ResourcesService;
import com.example.mymonitorbackend.mapper.ResourcesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


/**
* @author bohao
* @description Service implementation of database operations on table [Resources].
*/
@Service
public class ResourcesServiceImpl extends ServiceImpl<ResourcesMapper, Resources>
    implements ResourcesService{

    @Autowired
    private ResourcesMapper resourcesMapper;

    @Override
    public void saveData(JSONObject jsonData) {
        JSONObject jsonObject = new JSONObject(jsonData);

        try {
            String recordTimestamp = jsonObject.getString("record_timestamp");
            System.out.println(recordTimestamp);
            JSONArray recordTimestamps = JSON.parseArray(recordTimestamp);

        int length = recordTimestamps.size();

        for (int i = 0; i < length; i++) {
            Resources resources = new Resources();

            resources.setRecordTimestamp(String.valueOf(recordTimestamps.get(i)));
            resources.setCpufreq(jsonObject.getJSONArray("CPUFreq").getJSONArray(i).toString());
            resources.setDownload(BigDecimal.valueOf(jsonObject.getJSONArray("downLoad").getDouble(i)));
            resources.setUpload(BigDecimal.valueOf(jsonObject.getJSONArray("upLoad").getDouble(i)));
            if (i < jsonObject.getJSONArray("FPS").size()) {
                resources.setFps(BigDecimal.valueOf(jsonObject.getJSONArray("FPS").getDouble(i)));
            }
            resources.setCpuusage(BigDecimal.valueOf(jsonObject.getJSONArray("CPUUsage").getDouble(i)));
            if (jsonObject.getDouble("Latitude") == null){
                resources.setLatitude(BigDecimal.valueOf(37.42));
            } else{
                resources.setLatitude(BigDecimal.valueOf(jsonObject.getDouble("Latitude")));
            }
            if (jsonObject.getDouble("Longitude") == null){
                resources.setLongitude(BigDecimal.valueOf(-122.08));
            } else{
                resources.setLatitude(BigDecimal.valueOf(jsonObject.getDouble("Longitude")));
            }
            resources.setMemoryusage(BigDecimal.valueOf(jsonObject.getJSONArray("MemoryUsage").getDouble(i)));

            resourcesMapper.insert(resources);
        }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}




