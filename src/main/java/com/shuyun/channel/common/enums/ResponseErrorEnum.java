package com.shuyun.channel.common.enums;

import org.codehaus.jackson.annotate.JsonValue;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kui.liu
 * @since 2014/09/24 下午8:33
 */
public enum ResponseErrorEnum {

    PARAMS_NOT_MATCH("PARAMS_NOT_MATCH", "参数不匹配!");

    private ResponseErrorEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    // 序列化enum
    @JsonValue
    private Map<String, Object> serialize() {
        Map<String, Object> valueMap = new HashMap<>(2);
        valueMap.put("code", this.code);
        valueMap.put("message", this.message);
        return valueMap;
    }

    private String code;

    private String message;

}
