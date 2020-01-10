package com.mdtech.minio_sample.common.controller;

import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.sunnysuperman.commons.util.JSONUtil;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class JsonSerializerManager {
    private static Map<Type, ObjectSerializer> serializers = new HashMap<>();

    public static void register(Type type, ObjectSerializer serializer) {
        synchronized (serializers) {
            serializers.put(type, serializer);
        }
    }

    public static String serialize(Object result) {
        return JSONUtil.toJSONString(result, serializers);
    }

}
