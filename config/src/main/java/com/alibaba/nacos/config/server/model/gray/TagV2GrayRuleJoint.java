package com.alibaba.nacos.config.server.model.gray;

public enum TagV2GrayRuleJoint {
    AND("&&","AND"),
    OR("||","OR");
    
    public final String expression;
    
    public final String name;
    
    TagV2GrayRuleJoint(String expression, String name) {
        this.expression = expression;
        this.name = name;
    }
    
    public String getExpression() {
        return expression;
    }
    
    public String getName() {
        return name;
    }
}
