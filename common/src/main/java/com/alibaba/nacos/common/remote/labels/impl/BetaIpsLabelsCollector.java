package com.alibaba.nacos.common.remote.labels.impl;

import com.alibaba.nacos.common.remote.labels.LabelsCollector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class BetaIpsLabelsCollector implements LabelsCollector {
    @Override
    public String getName() {
        return "betaIps";
    }
    @Override
    public int getOrder() {
        return 500;
    }
    
    @Override
    public void init(Properties properties) {
    
    }
    
    @Override
    public Map<String, String> getLabels() {
        return new HashMap<String, String>(){{
            put("betaIps", "127.0.0.1,127.0.0.2");
        }};
    }
    
    @Override
    public List<String> getLabelsKeys() {
        return new ArrayList<String>(){{
            add("betaIps");
        }};
    }
    
}
