package com.alibaba.nacos.common.remote.labels.impl;

import com.alibaba.nacos.common.remote.labels.LabelsCollector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class TagV2LabelsCollector implements LabelsCollector {
    
    @Override
    public void init(Properties properties) {
    
    }
    
    @Override
    public Map<String, String> getLabels() {
        return new HashMap<String, String>(){{
            put("tagV2", "tagV2");
        }};
    }
    
    @Override
    public List<String> getLabelsKeys() {
        return new ArrayList<String>(){{
            add("tagV2");
        }};
    }
    
    @Override
    public int getOrder() {
        return 300;
    }
    
    @Override
    public String getName() {
        return "tagV2";
    }
}
