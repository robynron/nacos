package com.alibaba.nacos.common.remote.labels;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public interface LabelsCollector {
    void init(Properties properties);
    Map<String, String> getLabels();
    List<String> getLabelsKeys();
    int getOrder();
    String getName();
}
