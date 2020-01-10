package com.mdtech.minio_sample.common.entity;

public class KeyValue {

    private Integer key;
    private String type;

    private String val;

    public KeyValue() {
    }

    public KeyValue(Integer key, String val) {
        this.setKey(key);
        this.setVal(val);
    }

    public KeyValue(String type, String val) {
        this.setType(type);
        this.setVal(val);
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
