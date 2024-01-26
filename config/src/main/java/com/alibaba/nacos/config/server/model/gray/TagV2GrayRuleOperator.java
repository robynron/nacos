package com.alibaba.nacos.config.server.model.gray;

public enum TagV2GrayRuleOperator {
    IN("in","IN"),
    
    NOT_IN("not in","NOT_IN"),
    
    EXIST("exist","EXIST"),
    
    NOT_EXIST("not exist","NOT_EXIST");
    
    public final String expression;
    
    public final String name;
    
    TagV2GrayRuleOperator(String expression, String name) {
        this.expression = expression;
        this.name = name;
    }
}
