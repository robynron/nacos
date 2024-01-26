package com.alibaba.nacos.config.server.model.gray;

import java.util.ArrayList;
import java.util.List;

public class TagV2GrayRuleItem {
    
    public String key;
    
    public TagV2GrayRuleOperator operator;

    public final List<String> valueList = new ArrayList<>();
    
    public TagV2GrayRuleJoint joint;
    
    public TagV2GrayRuleItem(String key, TagV2GrayRuleOperator operator, TagV2GrayRuleJoint joint) {
        this.key = key;
        this.operator = operator;
        this.joint = joint;
    }
    
    //todo: chain builder
}
