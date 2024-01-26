package com.alibaba.nacos.common.remote.labels.impl;

import com.alibaba.nacos.common.remote.labels.LabelsCollector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class TagV1LabelsCollector implements LabelsCollector {
    @Override
    public String getName() {
        return "tagV1";
    }
    @Override
    public int getOrder() {
        return 400;
    }
    @Override
    public Map<String, String> getLabels() {
        return new HashMap<String, String>(){{
            put("tagV1", "tagV1");
        }};
    }
    
    @Override
    public List<String> getLabelsKeys() {
        return new ArrayList<String>(){{
            add("tagV1");
        }};
    }
    
    @Override
    public void init(Properties properties) {
    }

}
