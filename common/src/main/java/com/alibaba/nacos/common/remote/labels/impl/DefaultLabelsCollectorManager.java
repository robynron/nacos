package com.alibaba.nacos.common.remote.labels.impl;

import com.alibaba.nacos.common.remote.labels.LabelsCollector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.ServiceLoader;

public class DefaultLabelsCollectorManager implements com.alibaba.nacos.common.remote.labels.LabelsCollectorManager {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultLabelsCollectorManager.class);
    
    private Map<String, String> labels = new HashMap<>();
    
    private Properties properties;
    
    private boolean isLabelsInit = false;
    
    public DefaultLabelsCollectorManager(Properties properties) {
        init(properties);
    }
    
    private void init(Properties properties) {
        this.properties = properties;
    }
    
    public Map<String, String> getLabels() {
        if (isLabelsInit) {
            return labels;
        }
        synchronized (this) {
            if (isLabelsInit) {
                return labels;
            }
            isLabelsInit = true;
            initLabels();
        }
        return labels;
    }
    
    private void initLabels() {
        ServiceLoader<LabelsCollector> labelsCollectors = ServiceLoader.load(LabelsCollector.class);
        ArrayList<LabelsCollector> labelsCollectorsList = new ArrayList<>();
        for (LabelsCollector labelsCollector : labelsCollectors) {
            labelsCollectorsList.add(labelsCollector);
        }
        labelsCollectorsList.sort((o1, o2) -> o2.getOrder() - o1.getOrder());
        for (LabelsCollector labelsCollector : labelsCollectorsList) {
            labelsCollector.init(properties);
            LOGGER.info("process LabelsCollector with [name:{}]", labelsCollector.getName());
            for (Map.Entry<String, String> entry : labelsCollector.getLabels().entrySet()) {
                if (innerAddLabel(entry.getKey(), entry.getValue())) {
                    LOGGER.info("successfully add label with [key:{}, value:{}] for LabelsCollectorManager", entry.getKey(), entry.getValue());
                } else {
                    LOGGER.info("label with [key:{}, value:{}] already existed in LabelsCollectorManager with [value:{}]",
                            entry.getKey(), entry.getValue(), labels.get(entry.getKey()));
                }
            }
        }
    }
    
    private boolean innerAddLabel(String key, String value) {
        return null == labels.putIfAbsent(key, value);
    }
}
