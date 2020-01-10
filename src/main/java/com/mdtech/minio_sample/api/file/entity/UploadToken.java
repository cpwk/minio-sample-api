package com.mdtech.minio_sample.api.file.entity;

public class UploadToken {

    private String objectName;
    private String putUrl;
    private String url;
    private Long createdAt;

    public UploadToken(String objectName, String putUrl, String url, Long createdAt) {
        this.objectName = objectName;
        this.putUrl = putUrl;
        this.url = url;
        this.createdAt = createdAt;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPutUrl() {
        return putUrl;
    }

    public void setPutUrl(String putUrl) {
        this.putUrl = putUrl;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }
}
